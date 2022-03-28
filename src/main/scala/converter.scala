class converter {
  val dictionary = Map(("I", 1), ("IV", 4), ("V", 5), ("IX", 9), ("X", 10),
    ("XL", 40), ("L", 50), ("XC", 90), ("C", 100), ("CD", 400), ("D", 500), ("CM", 900), ("M", 1000))

  def translate(s: String, m: Map[String, Int]): Int = {
    var count = -1
    s.foldLeft(0)((z, l)=> {
        count = count + 1
        if ((count < s.length-1)&&(m.getOrElse(l.toString, 0) < m.getOrElse(s(count + 1).toString, 0))) {
          val x = s(count) + s(count + 1).toString
          //println(s"Step $x: " + m.getOrElse(x,0))
          z + m.getOrElse(x, 0)
        }else if ((count > 0)&&(m.getOrElse(l.toString, 0) > m.getOrElse(s(count - 1 ).toString, 0))){
         // println("Was here")
          z
        }
        else {
//          if(count>0){
//          println(s"prev val: ${count - 1}")}else {}
//          println(s"index: ${count}")
//          println(s"else $l: " + m.getOrElse(l.toString,0))
          z + m.getOrElse(l.toString,0)
        }
    })
  }
}