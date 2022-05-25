class Solution {
    fun removeDuplicates(nums: IntArray): Int {
         return nums.toSet().sorted().also {
            for(index in it.indices){
                nums[index] = it[index]
            }
        }.size
    }
}
