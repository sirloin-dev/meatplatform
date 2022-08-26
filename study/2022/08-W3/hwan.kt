/*
 * Runtime: 255 ms, faster than 95.74% of Kotlin online submissions for First Bad Version.
 * Memory Usage: 32.6 MB, less than 99.27% of Kotlin online submissions for First Bad Version.
 *
 * 매우 전형적인 이진 탐색 문제
 */
class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var left = 1
        var right = n

        while (left <= right) {
            val mid = left + (right - left) / 2
            // 가운데 기준으로
            if (isBadVersion(mid)) {
                // 찾았다면 down
                right = mid - 1
            } else {
                // 못 찾았다면 up
                left = mid + 1
            }
        }

        return left
    }
}
