class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:     
        seen = nums[0] - 1
        result = 0
        
        for x in nums:
            if x != seen:
                nums[result] = seen = x
                result += 1
        
        return result
    
# Runtime: 89 ms, faster than 89.01% of Python3 online submissions for Remove Duplicates from Sorted Array.
# Memory Usage: 15.5 MB, less than 96.54% of Python3 online submissions for Remove Duplicates from Sorted Array.
