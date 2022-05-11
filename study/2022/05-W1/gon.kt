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
