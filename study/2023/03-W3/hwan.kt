import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

/*
 * Runtime   267 ms   Beats  87.5%
 * Memory   39.9 MB   Beats  97.25% 
 */
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencies = HashMap<Int, Int>()

        // O(N)
        nums.forEach {
            val count = frequencies[it] ?: 0
            frequencies[it] = count + 1
        }

        return frequencies.entries                // O(1)
            .sortedByDescending { e -> e.value }  // O(N LogN)
            .take(k)                              // O(k)
            .map { it.key }                       // O(k)
            .toIntArray()                         // O(k)
    }
}

class TopKFrequentElements {
    @ParameterizedTest
    @MethodSource("testArgs")
    fun runSolution(nums: IntArray, k: Int, expected: IntArray) {
        val solution = Solution()

        val result = solution.topKFrequent(nums, k)

        result shouldBe expected
    }

    companion object {
        @JvmStatic
        fun testArgs(): Stream<Arguments> = Stream.of(
            Arguments.of(
                /* nums */     intArrayOf(1, 1, 1, 2, 2, 3),
                /* k    */     2,
                /* expected */ intArrayOf(1, 2)
            ),
            Arguments.of(
                /* nums */     intArrayOf(1, 2),
                /* k    */     2,
                /* expected */ intArrayOf(1, 2)
            ),
        )
    }
}
