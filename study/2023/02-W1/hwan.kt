import org.junit.jupiter.params.ParameterizedTest
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import test.com.sirloin.annotation.SmallTest
import java.util.*
import java.util.stream.Stream

@SmallTest
class Solution {
    @ParameterizedTest
    @MethodSource("args")
    fun runTest(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int, expected: Int) {
        findCheapestPrice(n, flights, src, dst, k) shouldBe expected
    }

    // Runtime 205ms, Beats 96.36%
    // Memory 37 MiB, Beats 80.97%
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        // 최저가 경로 방문 기억용
        val visits = IntArray(n).apply {
            /*
             * 아직 방문하지 않은 Node 의 값을 터무니없이 크게 잡아야
             * 가격 계산 단계에서 무조건 그쪽으로 가는걸 방지할 수 있음
             * 만약 0보다 작은 값(-1, Int.MIN_VALUE) 등을 Signature value 로 설정하면
             * Node 방문 단계에서 edge 의 합보다 작은 값이 나오게 되어 잘못된 판단을 할 수 있다.
             */
            Arrays.fill(this, Int.MAX_VALUE)

            // 시작 지점을 0으로 설정해야 계산이 꼬이지 않는다
            this[src] = 0
        }

        // k 보다 큰   반복은 의미없으니까 최대 k회만 반복함
        for (i in 0..k) {
            // 방문 경로 저장용 Queue (현재 depth 부터 끝: n 까지, 탐색기록을 복사)
            val queue = IntArray(n).apply {
                for (j in 0 until n) {
                    this[j] = visits[j]
                }
            }

            for (nodeInfo in flights) {
                val thisNode = nodeInfo[0]
                val nextNode = nodeInfo[1]
                val price = nodeInfo[2]

                // 방문 기록이 있는 node 인데 다음 node 로 가는 여행비용이 저렴하다면 가격 업데이트
                if (visits[thisNode] != Int.MAX_VALUE && visits[thisNode] + price < queue[nextNode]) {
                    queue[nextNode] = visits[thisNode] + price
                }
            }

            // 방문 기록 업데이트
            for (j in 0 until n) {
                visits[j] = queue[j]
            }
        }

        return if (visits[dst] == Int.MAX_VALUE) {
            // 가격 계산 로직과 k 반복조건에 따라 아직 방문한적이 없다면 평가 불가능
            -1
        } else {
            // 아니라면 계산한 가격을 반환
            visits[dst]
        }
    }

    companion object {
        @JvmStatic
        fun args(): Stream<Arguments> = Stream.of(
            Arguments.of(
                /* n */        4,
                /* flights */  arrayOf(
                    intArrayOf(0, 1, 100),
                    intArrayOf(1, 2, 100),
                    intArrayOf(2, 0, 100),
                    intArrayOf(1, 3, 600),
                    intArrayOf(2, 3, 200),
                ),
                /* src */      0,
                /* dst */      3,
                /* k */        1,
                /* expected */ 700
            ),
            Arguments.of(
                /* n */        3,
                /* flights */  arrayOf(
                    intArrayOf(0, 1, 100),
                    intArrayOf(1, 2, 100),
                    intArrayOf(0, 2, 500)
                ),
                /* src */      0,
                /* dst */      2,
                /* k */        1,
                /* expected */ 200
            ),
            Arguments.of(
                /* n */        3,
                /* flights */  arrayOf(
                    intArrayOf(0, 1, 100),
                    intArrayOf(1, 2, 100),
                    intArrayOf(0, 2, 500)
                ),
                /* src */      0,
                /* dst */      2,
                /* k */        0,
                /* expected */ 500
            )
        )
    }
}
