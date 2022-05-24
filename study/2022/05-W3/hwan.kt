/*
 * Runtime: 263 ms, faster than 91.16% of Kotlin online submissions for Remove Duplicates from Sorted Array.
 * Memory Usage: 38.4 MB, less than 92.97% of Kotlin online submissions for Remove Duplicates from Sorted Array.
 * 
 * 2 * N = O(N), O(N) 
 */
fun removeDuplicates(nums: IntArray): Int {
    val uniqueNums = ArrayList<Int>()
    var last = Int.MIN_VALUE
    nums.forEach {
        if (it == last) {
            return@forEach
        }

        last = it
        uniqueNums.add(last)
    }

    for (i in nums.indices) {
        nums[i] = if (i < uniqueNums.size) {
            uniqueNums[i]
        } else {
            -1
        }
    }

    return uniqueNums.size
}
