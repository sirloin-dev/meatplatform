class Solution {
    /**
     * 1. 왼쪽부터 나아가며 target 과 숫자를 비교
     * 2. 현재 숫자(nums[i])가 후보 목록에 있다면:
     *   2-1. 이미 예전에 그 숫자가 필요한 지점을 발견했으므로 결과 반환후 종료.
     * 3. 후보 목록에 target 을 만들기 위한 숫자를 target - nums[i] 로 index 와 함께 저장.
     *
     * <문제를 sort 하면 quicksort 처럼 2-pivot 으로 찾을 수 있어 더 쉽지만, sort 에 시간이 걸리므로 오히려 비효율적>
     * <처음에는 Index 를 보존하기 위해 TreeSet 을 생각했지만 어차피 숫자와 index 를 모두 저장해야 하므로 HashMap 을 쓰도록 구현 전략 변경>
     *
     *********************************************
     * Runtime: 263 ms, faster than 85.49% of Kotlin online submissions for Two Sum.
     * Memory Usage: 41.7 MB, less than 58.18% of Kotlin online submissions for Two Sum.
     *********************************************
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // <숫자, Index>
        val candidates = HashMap<Int, Int>()
        for (i in nums.indices) {
            val number = nums[i]
            if (candidates.containsKey(number)) {
                return intArrayOf(candidates[number]!!, i)
            }
            candidates[target - number] = i
        }

        throw IllegalArgumentException("Illegal Input!")
    }
}
