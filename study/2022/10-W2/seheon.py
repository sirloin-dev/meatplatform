# Runtime: 761 ms, faster than 96.05% of Python3 online submissions for Find the Town Judge.
# Memory Usage: 18.9 MB, less than 91.55% of Python3 online submissions for Find the Town Judge.

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        
        if n == 1:
            return 1

        candidated = defaultdict(int)

        for [truster, trustee] in trust:
            candidated[truster] = -1
            candidated[trustee] += 1
                
        for k, v in candidated.items():
            if v == n -1:
                return k
        
        return -1
        
