class converter {
  val dictionary = Map(("I", 1), ("IV", 4), ("V", 5), ("IX", 9), ("X", 10),
    ("XL", 40), ("L", 50), ("XC", 90), ("C", 100), ("CD", 400), ("D", 500), ("CM", 900), ("M", 1000))

  def translate(s: String, m: Map[String, Int]): Int = {
    s.foldLeft(0)((z, l)=> {
      if((s.indexOf(l) < s.length - 1) && s.indexOf(l) > 0){
        if(m.getOrElse(s(s.indexOf(l)).toString,0) < m.getOrElse(s(s.indexOf(l)+1).toString,0)){
         val x = s(s.indexOf(l)) + s(s.indexOf(l)+1).toString
          println(s"Step $l: " + z )
          z + m.getOrElse(x,0)
        }else if(m.getOrElse(s(s.indexOf(l)).toString,0) > m.getOrElse(s(s.indexOf(l)-1).toString,0)){
          z
        } else {
          z
        }
      }
      else if (s.indexOf(l) == 0){
        println(s"Step $l: " + z )
          z + m.getOrElse(l.toString,0)}
      else {
        z
      }
    })
  }
}