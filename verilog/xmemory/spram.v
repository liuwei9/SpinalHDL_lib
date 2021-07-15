// Generator : SpinalHDL v1.5.0    git head : 83a031922866b078c411ec5529e00f1b6e79f8e7
// Component : spram
// Git hash  : 7c80b4e3b0a60b316a6d9ae832dbea255ae9c4d9



module spram (
  input      [8:0]    addra,
  input      [31:0]   dina,
  output     [31:0]   douta,
  input               ena,
  input      [0:0]    wea,
  input               clk
);
  wire                temp_dbiterra;
  wire       [31:0]   temp_douta;
  wire                temp_sbiterra;
  wire                dbiterra;
  wire                sbiterra;
  wire                injectdbiterra;
  wire                injectsbiterra;
  wire                regcea;
  wire                rsta;
  wire                sleep;

  xpm_memory_spram #(
    .ADDR_WIDTH_A(9),
    .AUTO_SLEEP_TIME(0),
    .BYTE_WRITE_WIDTH_A(32),
    .CASCADE_HEIGHT(0),
    .ECC_MODE("no_ecc"),
    .MEMORY_INIT_FILE("none"),
    .MEMORY_INIT_PARAM("0"),
    .MEMORY_OPTIMIZATION("true"),
    .MEMORY_PRIMITIVE("block"),
    .MEMORY_SIZE(16384),
    .MESSAGE_CONTROL(0),
    .READ_DATA_WIDTH_A(32),
    .READ_LATENCY_A(1),
    .READ_RESET_VALUE_A("0"),
    .RST_MODE_A("SYNC"),
    .SIM_ASSERT_CHK(0),
    .USE_MEM_INIT(1),
    .WAKEUP_TIME("disable_sleep"),
    .WRITE_DATA_WIDTH_A(32),
    .WRITE_MODE_A("read_first") 
  ) temp (
    .dbiterra          (temp_dbiterra   ), //o
    .douta             (temp_douta      ), //o
    .sbiterra          (temp_sbiterra   ), //o
    .addra             (addra           ), //i
    .clka              (clk             ), //i
    .dina              (dina            ), //i
    .ena               (ena             ), //i
    .injectdbiterra    (injectdbiterra  ), //i
    .injectsbiterra    (injectsbiterra  ), //i
    .regcea            (regcea          ), //i
    .rsta              (rsta            ), //i
    .sleep             (sleep           ), //i
    .wea               (wea             )  //i
  );
  assign injectdbiterra = 1'b0;
  assign injectsbiterra = 1'b0;
  assign regcea = 1'b1;
  assign rsta = 1'b0;
  assign sleep = 1'b0;
  assign dbiterra = temp_dbiterra;
  assign douta = temp_douta;
  assign sbiterra = temp_sbiterra;

endmodule
