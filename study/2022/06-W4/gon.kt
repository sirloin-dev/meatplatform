fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums[0] >= target) return  0
        for (i in nums.indices){
            if (nums[i] == target) return i
            if (i > 0 && nums[i] > target && nums[i - 1] < target) return i
        }
        return nums.size
    }
