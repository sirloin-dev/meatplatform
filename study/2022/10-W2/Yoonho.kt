fun findJudge(n: Int, trust: Array<IntArray>): Int {
    val check = IntArray(n)
    trust.map {
        it[1]
    }.forEach {
        ++check[it - 1]
    }

    val mans = trust.map { it[0] }

    for (i in check.indices) {
        if (check[i] == n - 1 && !mans.contains(i + 1)) {
            return i + 1
        }
    }
    return -1
}
