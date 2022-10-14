const findJudge = (n, trust) => {
  const trustCounts = new Array(n + 1).fill(0);
    
  for (let [i, j] of trust) {
    --trustCounts[i];
    ++trustCounts[j];
  }
    
  for (let i = 1; i < trustCounts.length; ++i) if (trustCounts[i] === n - 1) return i;
  return -1;
};

// Runtime: 102 ms, faster than 95.30% of JavaScript online submissions for Find the Town Judge.
// Memory Usage: 50 MB, less than 95.45% of JavaScript online submissions for Find the Town Judge.
