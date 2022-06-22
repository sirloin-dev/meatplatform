class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        
        cursor = 0
        
        while len(nums) > 1:
            index = int(len(nums) / 2)
            if target > nums[index]:
                cursor += index
                nums = nums[index:]
            else:
                nums = nums[:index]
                
        if target > nums[0]:
            cursor += 1
                
        return cursor
                
# Runtime: 52 ms, faster than 90.65% of Python3 online submissions for Search Insert Position.
# Memory Usage: 14.7 MB, less than 40.25% of Python3 online submissions for Search Insert Position.
