class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        
        while m > 0 and n > 0:
            if nums1[m - 1] > nums2[n - 1]:
                nums1[m + n - 1] = nums1[m - 1]
                m -= 1
            else:
                nums1[m + n - 1] = nums2[n - 1]
                n -= 1
        
        if m == 0:
            nums1[:n] = nums2[:n]

# Runtime: 43 ms, faster than 82.88% of Python3 online submissions for Merge Sorted Array.
# Memory Usage: 13.9 MB, less than 37.51% of Python3 online submissions for Merge Sorted Array.
