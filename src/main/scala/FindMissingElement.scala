/*
  A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
  Your goal is to find that missing element.
  Write a function:
  object Solution { def solution(A: Array[Int]): Int }
  that, given a zero-indexed array A, returns the value of the missing element.
    For example, given array A such that:
    A[0] = 2
    A[1] = 3
    A[2] = 1
    A[3] = 5
  the function should return 4, as it is the missing element.
  Assume that:
    N is an integer within the range [0..100,000];
  the elements of A are all distinct;
  each element of array A is an integer within the range [1..(N + 1)].
  Complexity:
    expected worst-case time complexity is O(N);
  expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
  Elements of input arrays can be modified.
    */

object FindMissingElement extends App {

  val input = Array(1, 4, 1, 2) //3
  val input1: Array[Int] = Array(-1, -3) //1
  val input2 = Array(1, 2, 3) //4

  def solution(A: Array[Int]): Int = {
    def findMissing(in: Int, l: List[Int]): Int = {
      if (l.isEmpty || l.head != in) in
      else findMissing(in + 1, l.tail)
    }

    findMissing(1, A.toList.filter(_ > 0).distinct.sorted)
  }

  println(s"result::::::::${solution(input2)}")
}
