case class DataFrame(ssi: Seq[Seq[Any]], col: Seq[String]) {

  def show(): Unit = {
    val sep = Seq.fill(col.length)("---").mkString("+", "+", "+")
    val colform = col.mkString("|", "|", "|")
    val title = Seq(sep, colform, sep)
    val body = ssi.map(_.mkString("|", "|", "|"))
    val footer = sep :: Nil
    (title ++ body ++ footer).foreach(println)
//    (col +: sep +: ssi :+ sep).map(_.mkString("|")).foreach((println))

  }

  def join(right: DataFrame, on: Seq[String]): DataFrame = {
    //    val this.col.intersect(on)
    val ids = indices(on)
    val leftVs = this.ssi.map(r => ids.map(id => r(id)))
    val rightVs = right.ssi.map(r => ids.map(id => r(id)))
    val matchingVals = leftVs.intersect(rightVs)

    val joinCols = this.col ++ right.col
    DataFrame(this.ssi.filter(r => r(ids.head) == matchingVals.head.head), this.col)
  }

  def indices(on: Seq[String]): Seq[Int] = {
    col.zipWithIndex.filter(p => on.contains((p._1))).map(_._2)
  }

  def matchById(left: Seq[Any], right: Seq[Any], ids: Seq[Any]): (Seq[Any], Seq[Any]) = {
    val leftIds = ids.map(id => left(id))

  }

  def rowsByMatchesAndIds(
                         rows: Seq[Seq[Any]],
                         matches: Seq[Any],
                         ids: Seq[Int]): Seq[Seq[Any]] = ???
}

val rows = Seq(
  Seq("zero", true, 8),
  Seq("one", false, 3))
val matches = Seq(true, 8)
val ids = Seq(1,2)

