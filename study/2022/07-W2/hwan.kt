/*
 * m > n, 따라서 n 을 소비
 * 작은 숫자부터 비교할 경우 최악의 경우 m * n 이 될 수 있으므로 큰 숫자부터 비교: 항상 m + n
 *
 * Runtime: 173 ms, faster than 97.62% of Kotlin online submissions for Merge Sorted Array.
 * Memory Usage: 35.3 MB, less than 98.37% of Kotlin online submissions for Merge Sorted Array.
 */
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var end = m + n - 1
    var me = m - 1
    var ne = n - 1
    while (ne >= 0) {
        if (me >= 0) {
            nums1[end--] = if (nums1[me] > nums2[ne]) nums1[me--] else nums2[ne--]
        } else {
            nums1[end--] = nums2[ne--]
        }
    }
}
