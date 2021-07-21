package xfifo

import spinal.core._

class xpm_fifo_sync(
                       DOUT_RESET_VALUE: String = "0", // String
                       ECC_MODE: String = "no_ecc", // String
                       FIFO_MEMORY_TYPE: String = "auto", // String
                       FIFO_READ_LATENCY: Int = 1, // DECIMAL
                       FIFO_WRITE_DEPTH: Int = 2048, // DECIMAL
                       FULL_RESET_VALUE: Int = 0, // DECIMAL
                       PROG_EMPTY_THRESH: Int = 10, // DECIMAL
                       PROG_FULL_THRESH: Int = 10, // DECIMAL
                       RD_DATA_COUNT_WIDTH: Int = 1, // DECIMAL
                       READ_DATA_WIDTH: Int = 32, // DECIMAL
                       READ_MODE: String = "std", // String
                       SIM_ASSERT_CHK: Int = 0, // DECIMAL; 0=disable simulation messages, 1=enable simulation messages
                       USE_ADV_FEATURES: String = "0707", // String
                       WAKEUP_TIME: Int = 0, // DECIMAL
                       WRITE_DATA_WIDTH: Int = 32, // DECIMAL
                       WR_DATA_COUNT_WIDTH: Int = 1 // DECIMAL
                   ) extends BlackBox {
    addGeneric("DOUT_RESET_VALUE",DOUT_RESET_VALUE)
    addGeneric("ECC_MODE",ECC_MODE)
    addGeneric("FIFO_MEMORY_TYPE",FIFO_MEMORY_TYPE)
    addGeneric("FIFO_READ_LATENCY",FIFO_READ_LATENCY)
    addGeneric("FIFO_WRITE_DEPTH",FIFO_WRITE_DEPTH)
    addGeneric("FULL_RESET_VALUE",FULL_RESET_VALUE)
    addGeneric("PROG_EMPTY_THRESH",PROG_EMPTY_THRESH)
    addGeneric("PROG_FULL_THRESH",PROG_FULL_THRESH)
    addGeneric("RD_DATA_COUNT_WIDTH",RD_DATA_COUNT_WIDTH)
    addGeneric("READ_DATA_WIDTH",READ_DATA_WIDTH)
    addGeneric("READ_MODE",READ_MODE)
    addGeneric("SIM_ASSERT_CHK",SIM_ASSERT_CHK)
    addGeneric("USE_ADV_FEATURES",USE_ADV_FEATURES)
    addGeneric("WAKEUP_TIME",WAKEUP_TIME)
    addGeneric("WRITE_DATA_WIDTH",WRITE_DATA_WIDTH)
    addGeneric("WR_DATA_COUNT_WIDTH",WR_DATA_COUNT_WIDTH)


}

object xpm_fifo_sync {

}

class fifo_sync {

}

object fifo_sync {

}
