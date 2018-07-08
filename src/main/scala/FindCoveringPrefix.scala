/*
A non-empty array A consisting of N integers is given. The first covering prefix of array A is the smallest integer P such that 0≤P<N and such that every value that occurs in array A also occurs in sequence A[0], A[1], ..., A[P].

For example, the first covering prefix of the following 5−element array A:

  A[0] = 2
  A[1] = 2
  A[2] = 1
  A[3] = 0
  A[4] = 1
is 3, because sequence [ A[0], A[1], A[2], A[3] ] equal to [2, 2, 1, 0], contains all values that occur in array A.

Write a function

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the first covering prefix of A.

For example, given array A such that

  A[0] = 2
  A[1] = 2
  A[2] = 1
  A[3] = 0
  A[4] = 1
the function should return 3, as explained above.
 */

object FindCoveringPrefix extends App {

   val input = Array(2,2,1,0,1)

   def solution(input: Array[Int]): Int = {

     def findPrefix(in: Int, input: List[Int]): Int = {
        input match {
          case Nil => in
          case head :: tail =>
            if (input.contains(in))
              findPrefix(in+1,tail)
            else in
        }
     }
     findPrefix(0, input.toList.distinct)
   }

  println(s"result::::${solution(input)}")
}
