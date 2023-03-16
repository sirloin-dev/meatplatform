// Runtime
// 264 ms
// Beats
// 91.18%

// Memory
// 40.9 MB
// Beats
// 62.81%  
class Solution {

        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val counter : MutableMap<Int,Int> = mutableMapOf()

            // n
            nums.forEach {
                counter[it] = counter.getOrDefault(it , 0) + 1
            }

            val min = counter.values.sortedByDescending { it }.take(k).minOf { it }
            return counter.entries.filter { it.value >= min }.map { it.key }.toIntArray()
        }

// leetcode에서 지원으 안하길레 복붙하였습니ㄷ    
public inline fun <T, R : Comparable<R>> Iterable<T>.minOf(selector: (T) -> R): R {
    val iterator = iterator()
    if (!iterator.hasNext()) throw NoSuchElementException()
    var minValue = selector(iterator.next())
    while (iterator.hasNext()) {
        val v = selector(iterator.next())
        if (minValue > v) {
            minValue = v
        }
    }
    return minValue
}
    }
