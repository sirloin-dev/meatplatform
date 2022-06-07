class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        h, n = haystack, needle
        N = len(h)
        M = len(n)
        if M == 0: return 0
        
        for i in range(N-M+1):
            offset = i
            j = 0
            while j < M:
                if h[offset+j] != n[j]:
                    break
                j += 1
            if j == M:
                return i
            
        return -1
# Runtime: 44 ms, faster than 45.83% of Python3 online submissions for Implement strStr().
# Memory Usage: 14 MB, less than 15.29% of Python3 online submissions for Implement strStr().
