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

/*
문제의 조건 중, 정답이 반드시 유일하다는 부분을 이용하면 O(n) 의 코드를 작성 가능하다.
[...ans, ...buket[i]].size > k 일 케이스가 없다.
만약 존재한다면, 답은 유일하지 못하다.

Runtime 269 ms | Memory 40.9 MB
Beats   88.77% | Beats  68.15%
*/

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap: MutableMap<Int, Int> = mutableMapOf()
        val buket = arrayOfNulls<ArrayList<Int>>(nums.size + 1);
        for (num in nums) {
            if (!frequencyMap.contains(num)) {
                frequencyMap[num] = 1
                continue
            }
            frequencyMap[num] = frequencyMap[num]!! + 1
        }
        for (key in frequencyMap.keys) {
            val frequency = frequencyMap[key];
            if (buket[frequency!!] == null) {
                buket[frequency] = ArrayList<Int>()
            }
            buket[frequency]!!.add(key);
        }

        val ans = ArrayList<Int>()
        var idx = buket.size -1;
        
        while (ans.size < k && idx > 0) {
            buket[idx]?.let { ans.addAll(it) }
            idx--
        }
        return  ans.toIntArray()
    }
}
