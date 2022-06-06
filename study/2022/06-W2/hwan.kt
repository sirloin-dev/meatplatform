/*
 * Runtime: 152 ms, faster than 93.16% of Kotlin online submissions for Implement strStr().
 * Memory Usage: 33.4 MB, less than 98.35% of Kotlin online submissions for Implement strStr().
 *
 * Time Complexity: O(N1 + N2), where N1 = strlen(haystack), N2 = strlen(needle)
 * Space Complexity: O(1)
 *
 * 추가 읽을거리: https://stackoverflow.com/questions/24886/is-there-a-performance-difference-between-i-and-i-in-c
 */
fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) {
        return 0
    } else if (haystack.length < needle.length) {
        return -1
    }
    var i = 0
    var j = 0
    var index = 0
    while (i < haystack.length) {
        if (haystack[i] == needle[j]) {
            // KMP 알고리즘 실패함수 구현
            index = i
            while (i < haystack.length && j < needle.length && haystack[i] == needle[j]) {
                ++i
                ++j
            }
            if (j == needle.length) {
                return index
            } else {
                // 실패함수 이용: match 에 실패한 i 만큼 jump 해서 시간복잡도를 낮춘다
                j = 0
                i = index + 1
            }
        } else {
            ++i
        }
    }
    return -1
}
