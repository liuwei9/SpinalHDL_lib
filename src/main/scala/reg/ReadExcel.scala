package reg


import java.io.{ File, FileInputStream, FileOutputStream}
import org.apache.poi.ss.usermodel.{CellType, WorkbookFactory}

class ReadExcel(SCALA_PATH: String, SRC_EXCEL_PATH: String, MODULE_NAME: String) {

    val head = "import spinal.core._\nimport spinal.lib.bus.amba4.axilite._\nimport spinal.lib._\n\nclass " + MODULE_NAME + " extends Component {\n    val io = new Bundle {\n        val S_AXI = slave(AxiLite4(AxiLite4Config(32, 32)))\n"
    var io = ""
    val body = "    noIoPrefix()\n    AxiLite4SpecRenamer(io.S_AXI)\n    val factory = new AxiLite4SlaveFactory(io.S_AXI)\n"
    var footer = ""


    val excel_file_path = SRC_EXCEL_PATH
    //val excel_Workbook = new XSSFWorkbook(bis)
    val excel_Workbook = WorkbookFactory.create(new FileInputStream(new File(excel_file_path)))
    val excel_Sheet = excel_Workbook.getSheetAt(0)

    val lastNum = excel_Sheet.getLastRowNum

    var Offset_data = 0

    for (a <- 1 to lastNum) {
        val row = excel_Sheet.getRow(a)

//        val Offset = row.getCell(0)
//        Offset.setCellType(CellType.STRING)
//        val Offset_data = Offset.getStringCellValue

        val Name = row.getCell(0)
        Name.setCellType(CellType.STRING)
        val Name_data = Name.getStringCellValue

        val Description = row.getCell(1)
        Description.setCellType(CellType.STRING)
        val Description_data = Description.getStringCellValue

        val Access = row.getCell(2)
        Access.setCellType(CellType.STRING)
        val Access_data = Access.getStringCellValue

        val DataType = row.getCell(5)
        DataType.setCellType(CellType.STRING)
        val DataType_data = DataType.getStringCellValue


        if (Access_data == "READ_ONLY") {
            footer = footer + "    factory.read(io." + Name_data + "," + Offset_data + ",0,\"" + Description_data + "\")\n"
            if (DataType_data == "Bool") {
                io = io + "        val " + Name_data + "= in Bool()\n"
            } else {
                io = io + "        val " + Name_data + "= in Bits (32 bits)\n"
            }
        } else if (Access_data == "WRITE_ONLY") {
            val Reset = row.getCell(3)
            Reset.setCellType(CellType.STRING)
            val Reset_data = Reset.getStringCellValue
            val IS_SELF_CLEARING = row.getCell(4)
            IS_SELF_CLEARING.setCellType(CellType.STRING)
            val IS_SELF_CLEARING_data = IS_SELF_CLEARING.getStringCellValue
            if (IS_SELF_CLEARING_data == "TRUE") {
                footer = footer + "    io." + Name_data + ".clear()\n"
                footer = footer + "    factory.write(io." + Name_data + "," + Offset_data + ",0,\"" + Description_data + "\")\n"
            } else {
                footer = footer + "    factory.write(io." + Name_data + "," + Offset_data + ",0,\"" + Description_data + "\")\n"
            }
            if (DataType_data == "Bool") {
                io = io + "        val " + Name_data + "= out Bool() setAsReg() init " + (if (Reset_data == "0") "False" else "True") + "\n"
            } else {
                io = io + "        val " + Name_data + "= out Bits (32 bits) setAsReg() init " + Reset_data.toInt + "\n"
            }
        }
        Offset_data = Offset_data + 4
    }
    footer = footer + "}\n"
    io = io + "}\n"

    val end = "object " + MODULE_NAME + "{\n    def main(args: Array[String]): Unit = {\n        SpinalVerilog(new " + MODULE_NAME + ")\n    }\n}"
    val scala_file = new FileOutputStream(new File(SCALA_PATH + MODULE_NAME + ".scala"))
    scala_file.write((head + io + body + footer + end).getBytes())
    scala_file.close()
}

object ReadExcel {

    def main(args: Array[String]): Unit = {
        val scala_path = "src/main/scala/"
        val src_excel_path = "src/main/scala/reg/test.xlsx"
        val module_name = "ma"
        new ReadExcel(scala_path, src_excel_path, module_name)
    }
}