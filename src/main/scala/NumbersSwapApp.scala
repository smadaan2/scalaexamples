import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object NumbersSwapApp extends App{
  val y = Array(1,5,3,3,7)
  val z = Array(1,3,5,3,4)
  var list: ListBuffer[Int] = ListBuffer()

  def f3(l: Array[Int]): Boolean = {
    @tailrec
    def inner(list: List[Int], listB: ListBuffer[Int], count: Int): Int = {
      list match {
        case Nil => count
        case _ :: Nil => count
        case head :: tail => if (listB.nonEmpty)
          if(head <= tail.head && head <= listB.last) inner(tail,listB += head,count) else inner(tail,listB += tail.head,count+1)
        else if(head <= tail.head) inner(tail,listB += head,count) else inner(tail,listB += tail.head,count+1)
      }
    }
    val swapCount = inner(l.toList,list, 0)
    if (swapCount == 1) true else false
  }

  println(f3(y)) //true
  println(f3(z)) //false
}