package reg

import java.io.{File, FileInputStream, FileOutputStream}
import org.apache.poi.ss.usermodel.{Cell, WorkbookFactory}


class RegClass(var name: String, var base_addr: Int, var bit_offset: Int, var bit_width: Int, var description: String, var access: String, var reset: String, var is_self_clearing: String, var data_type: String) {

    def this(name: String, base_addr: Int, bit_offset: Int, bit_width: Int, description: String, access: String, data_type: String) {
        this(name, base_addr, bit_offset, bit_width, description, access, "", "", data_type)
    }

    override def toString = s"$name, $base_addr, $bit_offset, ,$bit_width, $description, $access, $reset, $is_self_clearing, $data_type"

}

class GenerateReg(SCALA_PATH: String, SRC_EXCEL_PATH: String, MODULE_NAME: String) {
    val head = "import spinal.core._\nimport spinal.lib.bus.amba4.axilite._\nimport spinal.lib._\n\nclass " + MODULE_NAME + " extends Component {\n    val io = new Bundle {\n        val S_AXI = slave(AxiLite4(AxiLite4Config(32, 32)))\n"
    var io = ""
    val body = "    noIoPrefix()\n    AxiLite4SpecRenamer(io.S_AXI)\n    val factory = new AxiLite4SlaveFactory(io.S_AXI)\n"
    var footer = ""

    var regList: List[RegClass] = Nil

    val excel_file_path = SRC_EXCEL_PATH
    val excel_Workbook = WorkbookFactory.create(new FileInputStream(new File(excel_file_path)))
    val excel_Sheet = excel_Workbook.getSheetAt(0)

    val lastNum = excel_Sheet.getLastRowNum

    //    var Offset_data = 0

    for (a <- 1 to lastNum) {
        val row = excel_Sheet.getRow(a)

        val Name = row.getCell(0)
        val Name_data = Name.getStringCellValue


        val Base_addr = row.getCell(1)

        val base_addr_data = Base_addr.getNumericCellValue.toInt

        val Bit_offset = row.getCell(2)
        val Bit_offset_data = Bit_offset.getNumericCellValue.toInt

        val Bit_width = row.getCell(3)
        val Bit_width_data = Bit_width.getNumericCellValue.toInt

        val Description = row.getCell(4)
        val Description_data = if (Description == null || Description.getCellType() == Cell.CELL_TYPE_BLANK) "" else Description.getStringCellValue

        val Access = row.getCell(5)
        val Access_data = Access.getStringCellValue

        val DataType = row.getCell(8)
        val DataType_data = DataType.getStringCellValue


        if (Access_data == "READ_ONLY") {
            footer = footer + "    factory.read(io." + Name_data + "," + base_addr_data + "," + Bit_offset_data + ",\"" + Description_data + "\")\n"
            if (DataType_data == "Bool") {
                io = io + "        val " + Name_data + "= in Bool()\n"
            } else {
                io = io + "        val " + Name_data + "= in Bits (" + Bit_width_data + " bits)\n"
            }
            regList = new RegClass(Name_data, base_addr_data, Bit_offset_data, Bit_width_data, Description_data, Access_data, DataType_data) :: regList
        } else if (Access_data == "WRITE_ONLY") {
            val Reset = row.getCell(6)
            val Reset_data = Reset.getNumericCellValue.toInt.toString
            val IS_SELF_CLEARING = row.getCell(7)
            val IS_SELF_CLEARING_data = IS_SELF_CLEARING.getBooleanCellValue.toString
            if (IS_SELF_CLEARING_data == "TRUE") {
                footer = footer + "    io." + Name_data + ".clear()\n"
            }
            //                footer = footer + "    factory.write(io." + Name_data + "," + Offset_data + "," + Bit_offset_data + ",\"" + Description_data + "\")\n"
            //            } else {
            footer = footer + "    factory.write(io." + Name_data + "," + base_addr_data + "," + Bit_offset_data + ",\"" + Description_data + "\")\n"
            //            }
            if (DataType_data == "Bool") {
                io = io + "        val " + Name_data + "= out Bool() setAsReg() init " + (if (Reset_data == "0") "False" else "True") + "\n"
            } else {
                io = io + "        val " + Name_data + "= out Bits (" + Bit_width_data + " bits) setAsReg() init " + Reset_data.toInt + "\n"
            }
            regList = new RegClass(Name_data, base_addr_data, Bit_offset_data, Bit_width_data, Description_data, Access_data, Reset_data, IS_SELF_CLEARING_data, DataType_data) :: regList
        }
        //        Offset_data = Offset_data + 4
    }
    footer = footer + "}\n"
    io = io + "}\n"

    val end = "object " + MODULE_NAME + "{\n    def main(args: Array[String]): Unit = {\n        SpinalVerilog(new " + MODULE_NAME + ")\n    }\n}"
    regList = regList.sortBy(r => (r.base_addr, r.bit_offset))(Ordering.Tuple2(Ordering.Int, Ordering.Int))
    flt(regList)
    val scala_file = new FileOutputStream(new File(SCALA_PATH + MODULE_NAME + ".scala"))
    scala_file.write((head + io + body + footer + end).getBytes())
    scala_file.close()
    println("Done")

    def flt(reg: List[RegClass]): Unit = {
        var old_base_addr = reg.head.base_addr * 32 + reg.head.bit_offset
        var old_addr_range = reg.head.bit_width
        var old_name = reg.head.name
        if (reg.head.data_type == "Bool")
            require(old_addr_range == 1, reg.head.name + "为Bool类型bit_width必须为1")
        if (reg.head.data_type == "Bits")
            require(old_addr_range > 0 && old_addr_range <= 32, reg.head.name + "为Bits类型bit_width必须介于1到32之间")
        require(reg.head.bit_offset + old_addr_range <= 32, reg.head.name + "的bit_offset+bit_width不能大于32")
        for (i <- 1 until reg.length) {
            val new_base_addr = reg(i).base_addr * 32 + reg(i).bit_offset
            val new_addr_range = reg(i).bit_width
            if (reg(i).data_type == "Bool")
                require(new_addr_range == 1, reg(i).name + "为Bool类型bit_width必须为1")
            if (reg(i).data_type == "Bits")
                require(new_addr_range > 0 && new_addr_range <= 32, reg(i).name + "为Bits类型bit_width必须介于1到32之间")
            require(reg(i).bit_offset + new_addr_range <= 32, reg(i).name + "的bit_offset+bit_width不能大于32")
            require(old_base_addr + old_addr_range < new_base_addr + 1, reg(i).name + "与" + old_name + "地址冲突")
            old_base_addr = new_base_addr
            old_addr_range = new_addr_range
            old_name = reg(i).name

        }

    }

}

object GenerateReg {

    def main(args: Array[String]): Unit = {
        val scala_path = "src/main/scala/"
        val src_excel_path = "F:\\vu9p\\pcie_yolo\\user\\reg\\Yolov4_tiny_reg.xlsx"
        val module_name = "Yolov4_tiny_reg"
        new GenerateReg(scala_path, src_excel_path, module_name)
    }
}
