name := "SpinalHDL_lib"

version := "0.1"

scalaVersion := "2.11.12"

fork := true

libraryDependencies ++= Seq(
    "com.github.spinalhdl" % "spinalhdl-core_2.11" % "1.6.0",
    "com.github.spinalhdl" % "spinalhdl-lib_2.11" % "1.6.0",
    compilerPlugin("com.github.spinalhdl" % "spinalhdl-idsl-plugin_2.11" % "1.6.0"),
    "com.google.code.gson" % "gson" % "2.7",
    "org.apache.poi" % "poi" % "3.8",
    "org.apache.poi" % "poi-ooxml" % "3.8"
)
