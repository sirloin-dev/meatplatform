/*
1. 문자배열을 가장 짧은 순서로 정렬합니다.
2. 가장 짧은 문자열을 기준으로 비교합니다.
*/
fun longestCommonPrefix(strs: Array<String>): String {
        var answer = ""

        val sortArr = strs.sortedBy { it.length }
        val first = sortArr.first()

        for (i: Int in first.indices) {
            val currentChar = first[i]
            if (sortArr.all { it[i] == currentChar }) {
                answer += currentChar
            } else {
                return answer
            }
        }

        return answer
}
