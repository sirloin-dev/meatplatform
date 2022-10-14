
class Solution {
  int findJudge(int n, List<List<int>> trust) {
    final List<int> trustCounts = List<int>.filled(n + 1, 0); // [0, 0, 0, ...];

    for (var trustProp in trust) {
      --trustCounts[trustProp.first];
      ++trustCounts[trustProp.last];
    }

    for (var i = 1; i < trustCounts.length; ++i) {
      if (trustCounts[i] == n - 1) return i;
    }

    return -1;
  }
}

// Runtime: 648 ms, faster than 66.67% of Dart online submissions for Find the Town Judge.
// Memory Usage: 177.9 MB, less than 33.33% of Dart online submissions for Find the Town Judge.
