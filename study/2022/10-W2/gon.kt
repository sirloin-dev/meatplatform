class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if(n < 2) return 1
        val believer = trust.map { it.first() }
        trust.groupBy { it.last() }.run {
            filter { it.value.size == n - 1 }.keys.forEach { key ->
                believer.find { it == key } ?: return key
            }
        }
        return -1
    }
}
