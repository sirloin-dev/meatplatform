class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        i, j, k = m + n - 1, m - 1, n - 1
        
        while j >= 0 and k >= 0:
            if nums1[j] < nums2[k]:
                nums1[i] = nums2[k]
                i -= 1
                k -= 1
            else:
                nums1[i] = nums1[j]
                i -= 1
                j -= 1
        while k >= 0:
            nums1[i] = nums2[k]
            i -= 1
            k -= 1
           
  """Runtime: 43 ms, faster than 82.88% of Python3 online submissions for Merge Sorted Array.
Memory Usage: 14 MB, less than 37.51% of Python3 online submissions for Merge Sorted Array."""
