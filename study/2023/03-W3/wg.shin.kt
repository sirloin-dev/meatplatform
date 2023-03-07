/*
Runtime 274 ms
Beats 82.25%

Memory 39.8 MB
Beats 98.17%

O(2 num.size * logk) 시간복잡도
*/

internal class Pair(val key: Int, val value: Int) : Comparable<Pair> {
    override fun compareTo(other: Pair): Int {
        return value - other.value
    }
}

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val memo: MutableMap<Int, Int> = mutableMapOf()
        val temp: PriorityQueue<Pair> = PriorityQueue()
        for (num in nums) {
            if (!memo.contains(num)) {
                memo[num] = 1
                continue
            }
            memo[num] = memo[num]!! + 1
        }
        for (case in memo) {
            if (temp.size < k) {
                temp.offer(Pair(case.key, case.value))
                continue
            }
            if (temp.first().value < case.value) {
                temp.poll()
                temp.offer(Pair(case.key, case.value))
            }
        }
        return temp.map { it.key }.toIntArray()
    }
}
