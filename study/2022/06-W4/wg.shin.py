class Solution:
    def searchInsert(self, nums: List[int], target: int):
        if len(nums) == 1:
            if target <= nums[0]:
                return 0
            return 1
        def sol(startIdx, endIdx):
            if endIdx - startIdx == 0:
                if target <= nums[startIdx]:
                    return startIdx
                return startIdx + 1
            if endIdx - startIdx == 1:
                if target <= nums[startIdx]:
                    return startIdx
                if target <= nums[startIdx + 1]:
                    return startIdx + 1
                return startIdx + 2
            midIdx = startIdx + (endIdx - startIdx)//2 
            if target > nums[midIdx]:
                return sol(midIdx + 1, endIdx)
            return sol(startIdx, midIdx)
        
        return sol(0, len(nums) - 1)
      
"""
Runtime: 54 ms, faster than 87.70% of Python3 online submissions for Search Insert Position.
Memory Usage: 15 MB, less than 6.21% of Python3 online submissions for Search Insert Position.
recursive func 의 경우 heapStack을 차지하기 때문에 메모리는 어쩔수 없는거같다..
"""
