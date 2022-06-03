object spark extends App{
  val df = DataFrame(Seq(Seq(1,2,3), Seq(4,5,6)), Seq("jeden", "dwa", "trzy"))
  df.show()
}
