 /*
  * 알고리즘 효율: O(N^2)
  *
  * 문제 이해 잘못해서 쓸데없이 복잡하게 풀었다.
  *
  * arrayOf("racecar", "flower", "flow", "flight", "rust")       // "fl" (아님, 실제로는 "")
  * arrayOf("flower", "flow", "racecar", "rare", "rafflesia")    // "ra" (아님, 실제로는 "")
  * arrayOf("dog","racecar","car")                               // ""
  * arrayOf("a")                                                 // "a"
  * arrayOf("flower","flow","flight")                            // "fl"
  *
  * 즉 모든 element 들의 첫번째 글자가 하나라도 같지 않다면 즉시 종
  */
fun longestCommonPrefix(strs: Array<String>): String {
  // 다른 사람들처럼 first element 기준으로 글자 찾는 알고리즘으로 풀면 됨
}
