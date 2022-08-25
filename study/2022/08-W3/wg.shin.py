class Solution:
    def firstBadVersion(self, n: int):
        start = 1
        end = n + 1
        while start < end:
            mid = (end + start) // 2
            if isBadVersion(mid):
                end = mid
                continue
            start = mid + 1
        return start
      

# Runtime: 24 ms, faster than 99.02% of Python3 online submissions for First Bad Version.
# Memory Usage: 13.9 MB, less than 62.49% of Python3 online submissions for First Bad Version.
