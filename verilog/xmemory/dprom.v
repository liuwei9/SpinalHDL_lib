// Generator : SpinalHDL v1.5.0    git head : 83a031922866b078c411ec5529e00f1b6e79f8e7
// Component : dprom
// Git hash  : 01c2814c6e52c94d3abf3fe3b5ef77fdd2263bbf



module dprom (
  input      [8:0]    addra,
  input               clka,
  output     [31:0]   douta,
  input               ena,
  input      [8:0]    addrb,
  input               clkb,
  output     [31:0]   doutb,
  input               enb
);
  wire                temp_dbiterra;
  wire                temp_dbiterrb;
  wire       [31:0]   temp_douta;
  wire       [31:0]   temp_doutb;
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

  xpm_memory_dprom #(
    .ADDR_WIDTH_A(9),
    .ADDR_WIDTH_B(9),
    .AUTO_SLEEP_TIME(0),
    .CASCADE_HEIGHT(0),
    .CLOCKING_MODE("common_clock"),
    .ECC_MODE("no_ecc"),
    .MEMORY_INIT_FILE("b.mem"),
    .MEMORY_INIT_PARAM(""),
    .MEMORY_OPTIMIZATION("true"),
    .MEMORY_PRIMITIVE("block"),
    .MEMORY_SIZE(16384),
    .MESSAGE_CONTROL(0),
    .READ_DATA_WIDTH_A(32),
    .READ_DATA_WIDTH_B(32),
    .READ_LATENCY_A(2),
    .READ_LATENCY_B(2),
    .READ_RESET_VALUE_A("0"),
    .READ_RESET_VALUE_B("0"),
    .RST_MODE_A("SYNC"),
    .RST_MODE_B("SYNC"),
    .SIM_ASSERT_CHK(0),
    .USE_MEM_INIT(1),
    .WAKEUP_TIME("disable_sleep") 
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
    .sleep             (sleep           )  //i
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
