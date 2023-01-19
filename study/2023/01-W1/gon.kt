
// 문제를 풀면서 string을 int로 바꿀때 정합성 검사에 굉장히 많은 노가다가 들어간다는것을 알았다(java17 기준) 우아하게는 못한다
// 여담으로 문제의 좋아요 싫어요 비율이 1 : 3 인 이유가 있는것같다
class Solution {
 
    private val numberPool = ('0'..'9')

    private val pm = listOf<Char>('+', '-')

    private val intPool = pm + numberPool

  fun myAtoi(s: String): Int {
        val n = StringBuffer()
        (s.takeIf { it.isNotBlank() }?.trim().takeIf { intPool.contains(it?.first()) }
            ?: return 0).let {
            var pmFlag = false
            var afterStr = false
            run {
                it.forEachIndexed { index, num ->
                    if (num == '.') {
                        return@run
                    }
                    if (pm.contains(num)) {
                        if (pmFlag || numberPool.contains(n.lastOrNull())) {
                           return@run
                        }
                        pmFlag = true
                        n.append(num)
                        return@forEachIndexed
                    }
                    if (numberPool.contains(num)) {
                        n.append(num)
                    } else {
                        if (pmFlag || numberPool.contains(n.lastOrNull())) {
                            return@run
                        }
                    }
                }
            }
        }
        return try {
            if (n.length < 2 && pm.contains(n.first())) {
                0
            } else {
                n.toString().toInt()
            }
        } catch (e: NumberFormatException) {
            if (n.first() == '-') {
                Int.MIN_VALUE
            } else {
                Int.MAX_VALUE
            }
        }
    }

}
