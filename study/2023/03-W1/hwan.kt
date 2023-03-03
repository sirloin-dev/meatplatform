import io.kotest.matchers.shouldBe
import java.util.*
import java.util.stream.Stream

/*
 * Runtime 629.ms  Beats   100%
 * Memory  49.6MiB Beats 97.99%
 */
internal class Solution {
    // 역방향으로 가면 공간을 O(N) 으로 절약할 수 있음
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val size = temperatures.size
        val result = IntArray(size)

        for (i in size - 1 downTo 0) {
            var j = i + 1

            /*
             * j 가 index out of bound 를 일으키지 않는 범위 내에서, temperature[j] 가 current = temperature[i] 보다 작으면,
             * current 는 최소한 1일 이상을 기다려야 한다. 따라서 current 보다 큰 temperature[j] 가 나올 때 까지,
             * temperature[j] 를 현재 계산한 index 만큼 점프한다. 왜냐면 현재 값보다 최소 temperature[j] +1 일을 더 기다려야
             * 최소한 current 보다 큰 온도가 나오기 때문이다.
             *
             * 하지만 이 방법으로는 만약 온도가 감소하는 패턴이 나오면 꼼짝없이 O(N²) 가 된다.
             * 온도가 증가하는 패턴에서는 O(N) 이 된다. 따라서 표준편차(SD)가 50 이라고 가정한 일반적인 패턴에서는
             * O(N * M), where M = log(N) 을 기대할 수 있다.
             */
            while (j < size && temperatures[j] <= temperatures[i]) {
                j = if (result[j] > 0) {
                    result[j] + j
                } else {
                    size
                }
            }

            if (j < size) {
                result[i] = j - i
            } else {
                result[i] = 0
            }
        }

        return result
    }
}

@SmallTest
class DailyTemperaturesRunner {
    @ParameterizedTest
    @MethodSource("solutionInputOutputs")
    fun runSolution(input: IntArray, expected: IntArray) {
        val actual = solution.dailyTemperatures(input)

        actual shouldBe expected
    }

    companion object {
        @JvmStatic
        fun solutionInputOutputs(): Stream<Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(73, 74, 75, 71, 69, 72, 76, 73),
                intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)
            ),
            Arguments.of(
                intArrayOf(30, 40, 50, 60),
                intArrayOf(1, 1, 1, 0)
            ),
            Arguments.of(
                intArrayOf(30, 60, 90),
                intArrayOf(1, 1, 0)
            ),
            Arguments.of(
                intArrayOf(99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80),
                intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
            ),
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
                intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0)
            )
        )
    }
}

