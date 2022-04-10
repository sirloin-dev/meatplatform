class Solution {
     fun twoSum(nums: IntArray, target: Int): IntArray {
        for(i in nums.indices){
            for(k in i+1 until nums.size){
                if((nums[i] + nums[k]) == target){
                    return arrayOf(i, k).toIntArray()
                }
            }
        }
    
        throw IllegalArgumentException();
     }
}
