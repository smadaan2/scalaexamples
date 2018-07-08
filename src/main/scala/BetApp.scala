import scala.annotation.tailrec
import scala.math.abs

/**
  * Given an integer N and integer K, returns the minimum number of rounds that are necessary for John to leave the casino with N chips,
  * having played all-in no more than K times
  */

object BetApp extends App {
  def solution(n: Int, k: Int): Int = {
    @tailrec
    def findNumberOfRounds(k: Int, nrOfrounds: Int, totalChipsRequired: Int): Int = {
      if (totalChipsRequired == n) nrOfrounds
      else if (k > 0 && totalChipsRequired == abs(n/4)) findNumberOfRounds(k-1, nrOfrounds + 1, totalChipsRequired * 2)
      else if (k > 0 && totalChipsRequired == abs(n/2)) findNumberOfRounds(k-1, nrOfrounds + 1, totalChipsRequired * 2)
      else findNumberOfRounds(k, nrOfrounds + 1, totalChipsRequired + 1)
    }
    findNumberOfRounds(k, 0, 1)
  }
  println(solution(8,0))
}