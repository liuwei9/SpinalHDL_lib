// Generator : SpinalHDL v1.5.0    git head : 83a031922866b078c411ec5529e00f1b6e79f8e7
// Component : tdpram
// Git hash  : 8b2d8e1c73fdc981ca5a0f3777a71643b434acd4



module tdpram (
  input      [8:0]    addra,
  input               clka,
  input      [31:0]   dina,
  output     [31:0]   douta,
  input               ena,
  input      [0:0]    wea,
  input      [9:0]    addrb,
  input               clkb,
  input      [15:0]   dinb,
  output     [15:0]   doutb,
  input               enb,
  input      [0:0]    web
);
  wire                temp_dbiterra;
  wire                temp_dbiterrb;
  wire       [31:0]   temp_douta;
  wire       [15:0]   temp_doutb;
  wire                temp_sbiterra;
  wire                temp_sbiterrb;
  wire                dbiterra;
  wire                dbiterrb;
  wire                sbiterra;
  wire                sbiterrb;
  wire                injectdbiterra;
  wire                injectdbiterrb;
  wire                injectsbiterra;
  wire                injectsbiterrb;
  wire                regcea;
  wire                regceb;
  wire                rsta;
  wire                rstb;
  wire                sleep;

  xpm_memory_tdpram #(
    .ADDR_WIDTH_A(9),
    .ADDR_WIDTH_B(10),
    .AUTO_SLEEP_TIME(0),
    .BYTE_WRITE_WIDTH_A(32),
    .BYTE_WRITE_WIDTH_B(16),
    .CASCADE_HEIGHT(0),
    .CLOCKING_MODE("common_clock"),
    .ECC_MODE("no_ecc"),
    .MEMORY_INIT_FILE("none"),
    .MEMORY_INIT_PARAM("0"),
    .MEMORY_OPTIMIZATION("true"),
    .MEMORY_PRIMITIVE("block"),
    .MEMORY_SIZE(16384),
    .MESSAGE_CONTROL(0),
    .READ_DATA_WIDTH_A(32),
    .READ_DATA_WIDTH_B(16),
    .READ_LATENCY_A(2),
    .READ_LATENCY_B(2),
    .READ_RESET_VALUE_A("0"),
    .READ_RESET_VALUE_B("0"),
    .RST_MODE_A("SYNC"),
    .RST_MODE_B("SYNC"),
    .SIM_ASSERT_CHK(0),
    .USE_EMBEDDED_CONSTRAINT(0),
    .USE_MEM_INIT(1),
    .WAKEUP_TIME("disable_sleep"),
    .WRITE_DATA_WIDTH_A(32),
    .WRITE_DATA_WIDTH_B(16),
    .WRITE_MODE_A("read_first"),
    .WRITE_MODE_B("read_first") 
  ) temp (
    .dbiterra          (temp_dbiterra   ), //o
    .dbiterrb          (temp_dbiterrb   ), //o
    .douta             (temp_douta      ), //o
    .doutb             (temp_doutb      ), //o
    .sbiterra          (temp_sbiterra   ), //o
    .sbiterrb          (temp_sbiterrb   ), //o
    .addra             (addra           ), //i
    .addrb             (addrb           ), //i
    .clka              (clka            ), //i
    .clkb              (clkb            ), //i
    .dina              (dina            ), //i
    .dinb              (dinb            ), //i
    .ena               (ena             ), //i
    .enb               (enb             ), //i
    .injectdbiterra    (injectdbiterra  ), //i
    .injectdbiterrb    (injectdbiterrb  ), //i
    .injectsbiterra    (injectsbiterra  ), //i
    .injectsbiterrb    (injectsbiterrb  ), //i
    .regcea            (regcea          ), //i
    .regceb            (regceb          ), //i
    .rsta              (rsta            ), //i
    .rstb              (rstb            ), //i
    .sleep             (sleep           ), //i
    .wea               (wea             ), //i
    .web               (web             )  //i
  );
  assign injectdbiterra = 1'b0;
  assign injectdbiterrb = 1'b0;
  assign injectsbiterra = 1'b0;
  assign injectsbiterrb = 1'b0;
  assign regcea = 1'b1;
  assign regceb = 1'b1;
  assign rsta = 1'b0;
  assign rstb = 1'b0;
  assign sleep = 1'b0;
  assign dbiterra = temp_dbiterra;
  assign dbiterrb = temp_dbiterrb;
  assign douta = temp_douta;
  assign doutb = temp_doutb;
  assign sbiterra = temp_sbiterra;
  assign sbiterrb = temp_sbiterrb;

endmodule
