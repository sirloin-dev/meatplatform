/*
 * Runtime: 491 ms, faster than 93.18% of Kotlin online submissions for Find the Town Judge.
 * Memory Usage: 58.7 MB, less than 100.0% of Kotlin online submissions for Find the Town Judge.
*/
fun findJudge(n: Int, trust: Array<IntArray>): Int {
    // 지금 사람들이 누구를 믿는가? 점수 제일 높은 사람이 누구인가?
    val scores = ArrayList<Int>(n).apply {
        repeat(n) { add(0) }

        trust.forEach {
            val person = it[0]
            val trusts = it[1]
            /*
             * 누군가를 믿는 사람의 점수는 1 하락
             * 자신이 지목되었는데, 자신이 남을 믿게되면 문제 성립 x
             * 그리고 judge 판단조건 달성을 불가능하게 한다.
             */
            --this[person - 1]
            // 믿음의 대상은 점수 1 상승
            ++this[trusts - 1]
        }
    }

    scores.forEachIndexed { i, it ->
        // 문제 조건상 모든 node 가 한 node 를 가리켜야 하므로 n - 1 edge 를 가지는 현재 녀석이 judge 다.
        if (it == n - 1) {
            return i + 1
        }
    }

    return -1
}
