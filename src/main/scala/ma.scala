import spinal.core._
import spinal.lib.bus.amba4.axilite._
import spinal.lib._

class ma extends Component {
    val io = new Bundle {
        val S_AXI = slave(AxiLite4(AxiLite4Config(32, 32)))
        val intr= in Bool()
        val dma_addr= out Bits (32 bits) setAsReg() init 0
        val state= out Bool() setAsReg() init False
        val data= in Bits (32 bits)
}
    noIoPrefix()
    AxiLite4SpecRenamer(io.S_AXI)
    val factory = new AxiLite4SlaveFactory(io.S_AXI)
    factory.read(io.intr,0,0,"中断")
    factory.write(io.dma_addr,0,0,"DMA地址")
    io.state.clear()
    factory.write(io.state,8,0,"状态")
    factory.read(io.data,12,0,"数据")
    factory.printDataModel()
}
object ma{
    def main(args: Array[String]): Unit = {
        SpinalVerilog(new ma)
    }
}