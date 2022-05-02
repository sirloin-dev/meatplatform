class Solution {
    private val bracketPairs = hashMapOf('(' to ')', '{' to '}', '[' to ']')

    /*
     * Runtime: 146 ms, faster than 92.07% of Kotlin online submissions for Valid Parentheses.
     * Memory Usage: 41 MB, less than 5.10% of Kotlin online submissions for Valid Parentheses.
     *
     * 괄호의 쌍은 모두 'valid(여닫는 쌍의 pattern 이 절대로 틀리지 않음)' 이므로 pop 시점의 validity 를 검사하면 된다.
     * 닫는 괄호의 시점에 pop 불가능이거나 또는 pop 대상이 match 하지 않으면 즉시 평가를 종료하도록 구현하면 된다.
     */
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>(10000)
        for (c in s) {
            if (bracketPairs.contains(c)) {
                stack.push(c)
            } else {
                if (stack.isEmpty()) {
                    return false
                }

                val openingBracket = stack.pop()
                val expectedClosingBracket = bracketPairs[openingBracket]
                if (c != expectedClosingBracket) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }

    private fun <T> ArrayDeque<T>.push(e: T) {
        addFirst(e)
    }

    private fun <T> ArrayDeque<T>.pop(): T {
        return removeFirst()
    }
}
