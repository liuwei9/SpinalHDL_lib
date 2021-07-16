package xmemory
import spinal.core._
class xpm_memory_tdpram(
                           ADDR_WIDTH_A: Int = 6, // DECIMAL
                           ADDR_WIDTH_B: Int = 6, // DECIMAL
                           AUTO_SLEEP_TIME: Int = 0, // DECIMAL
                           BYTE_WRITE_WIDTH_A: Int = 32, // DECIMAL
                           BYTE_WRITE_WIDTH_B: Int = 32, // DECIMAL
                           CASCADE_HEIGHT: Int = 0, // DECIMAL
                           CLOCKING_MODE: String = "common_clock", // String
                           ECC_MODE: String = "no_ecc", // String
                           MEMORY_INIT_FILE: String = "none", // String
                           MEMORY_INIT_PARAM: String = "0", // String
                           MEMORY_OPTIMIZATION: String = "true", // String
                           MEMORY_PRIMITIVE: String = "auto", // String
                           MEMORY_SIZE: Int = 2048, // DECIMAL
                           MESSAGE_CONTROL: Int = 0, // DECIMAL
                           READ_DATA_WIDTH_A: Int = 32, // DECIMAL
                           READ_DATA_WIDTH_B: Int = 32, // DECIMAL
                           READ_LATENCY_A: Int = 2, // DECIMAL
                           READ_LATENCY_B: Int = 2, // DECIMAL
                           READ_RESET_VALUE_A: String = "0", // String
                           READ_RESET_VALUE_B: String = "0", // String
                           RST_MODE_A: String = "SYNC", // String
                           RST_MODE_B: String = "SYNC", // String
                           SIM_ASSERT_CHK: Int = 0, // DECIMAL; 0=disable simulation messages, 1=enable simulation messages
                           USE_EMBEDDED_CONSTRAINT: Int = 0, // DECIMAL
                           USE_MEM_INIT: Int = 1, // DECIMAL
                           WAKEUP_TIME: String = "disable_sleep", // String
                           WRITE_DATA_WIDTH_A: Int = 32, // DECIMAL
                           WRITE_DATA_WIDTH_B: Int = 32, // DECIMAL
                           WRITE_MODE_A: String = "no_change", // String
                           WRITE_MODE_B: String = "no_change" // String
                       ) extends BlackBox{

}
class tdpram {

}
