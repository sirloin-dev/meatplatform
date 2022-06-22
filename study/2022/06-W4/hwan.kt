// 예전에 만들어뒀던 로직 그냥 올려봄

/**
 * Runtime: 159 ms, faster than 89.15% of Kotlin online submissions for Implement strStr().
 * Memory Usage: 33.4 MB, less than 99.01% of Kotlin online submissions for Implement strStr().
 */
@Suppress("LoopWithTooManyJumpStatements")
fun <T : Comparable<T>> List<T>.findInsertPosition(input: T): Int {
    var low = 0
    var hi = this.size
    while (low < hi) {
        val diff = hi - low
        val mid = (hi + low) / 2
        val data = this[mid]

        if (diff == 1) {
            if (input > data) {
                low += 1
            }
            break
        } else {
            if (input > data) {
                low = mid
            } else if (input < data) {
                hi = mid
            } else {
                low = mid + 1
                break
            }
        }
    }

    return low
}

