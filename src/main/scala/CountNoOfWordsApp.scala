/**
  * This will split sentence based on (.,?,!) and then we have to count no of words in each line.
  */
object CountNoOfWordsApp {

  val s: String = "We test coders. Give us a try?"

  val r = s.split("\\.|\\?|!").toList.map(f => f.split(" ").toList.filterNot(_ == "").size).max
  println(r)

}