class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        for i in range(len(haystack) - len(needle) + 1):
            if haystack[i:].startswith(needle):
                return i
        
        return -1
    
# Runtime: 34 ms, faster than 78.35% of Python3 online submissions for Implement strStr().
# Memory Usage: 13.8 MB, less than 67.60% of Python3 online submissions for Implement strStr().
