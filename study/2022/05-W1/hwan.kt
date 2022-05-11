 /*
  * 알고리즘 효율: O(N^2)
  * 인터넷에 떠도는 0번째 값 기준으로 검사하는 솔루션은 longest common prefix 가 [0] 이 아닌 곳에서 나타나면 동작하지 않음!!
  * sort 도 적절한 해결책이 될 수 없음!! [0] index 가 반드시 기준이 된다는 보장이 없기 때문이다.
  *
  * arrayOf("racecar", "flower", "flow", "flight", "rust")       // "fl"
  * arrayOf("flower", "flow", "racecar", "rare", "rafflesia")    // "ra"
  * arrayOf("dog","racecar","car")                               // ""
  * arrayOf("a")                                                 // "a"
  *
  * 1. 길이 제일 긴 글자를 찾는다(lMax).
  * 2. i = 0 부터 lMax 까지 돌면서:
  *   2-1. prefix 와 현재 글자를 더한 새로운 prefix 의 갯수를 모두 기록한다
  *   2-2. 기록한 prefix 들의 갯수를 모두 기록한다
  * 3. prefix 와 갯수를 기록한 집합을 길이 기준으로 분류하고
  *   3-1. 집합을 글자 길이 기준으로 정렬한 뒤
  *   3-2. 그 중에서 등장 횟수가 제일 많은 후보들을 선별한다.
  * 4. step 3 에서 선별한 집합을 모두 돌면서 길이와 등장 횟수가 제일 많은 그룹을 선별한다.
  *
  * Runtime: 217 ms, faster than 69.22% of Kotlin online submissions for Longest Common Prefix.
  * Memory Usage: 36.2 MB, less than 63.28% of Kotlin online submissions for Longest Common Prefix.
 */
fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) {
        return ""
    }

    if (strs.size == 1) {
        return strs.first()
    }

    val lMax = strs.maxOf { it.length }
    val prefixCandidates = HashMap<String, Int>()
    var longestPrefix = ""
    for (i in 0 until lMax) {
        for (j in strs.indices) {
            val str = strs[j]
            if (str.isEmpty() || str.length <= i || !str.startsWith(longestPrefix)) {
                continue
            }

            val currentPrefix = longestPrefix + str[i]
            val count = prefixCandidates[currentPrefix].also {
                if (it == null) {
                    prefixCandidates[currentPrefix] = 0
                }
            } ?: 0

            prefixCandidates[currentPrefix] = count + 1
        }

        // 여기서 strs 를 조작하면 시간 좀더 단축 가능
        longestPrefix = prefixCandidates.entries.maxByOrNull { it.value }?.key ?: ""
        if (longestPrefix.isEmpty()) {
            return ""
        }

        val occurrenceGroup = prefixCandidates.entries.groupBy { it.value }
        // 첫번째 글자가 모두 다르면 common prefix 가 없으므로 즉시 종료
        if (occurrenceGroup.keys.size == 1 && occurrenceGroup.keys.first() == 1) {
            return ""
        }
    }

    // Step 3: prefix 와 갯수를 기록한 집합을 길이 기준으로 분류
    val lengthySet = prefixCandidates.entries.groupBy { it.key.length }
        .filter { it.value.isNotEmpty() }
        .flatMapTo(HashSet<Map.Entry<String, Int>>()) { lengthGroup ->
            // Step 3-1: 길이 기준으로 정렬
            val occurrenceSorted = lengthGroup.value.sortedByDescending { it.value }
            // Step 3-2. 그 중에서 등장 횟수가 제일 많은 후보들을 선별한다.
            return@flatMapTo occurrenceSorted.filter { it.value == occurrenceSorted.first().value }
        }

    // Step 4: Step 3 에서 선별한 집합을 모두 돌면서 길이와 등장 횟수가 제일 많은 그룹을 선별한다.
    var current = Pair("", 0)
    lengthySet.forEach {
        // 길이와 등장횟수가 현재 후보보다 길면 current 를 교체
        if (it.value > current.second || (it.value == current.second && it.key.length > current.first.length)) {
            current = it.toPair()
        }
    }

    return current.first
}
