class Solution {
  int findJudge(int n, List<List<int>> trust) {
    Map<int, List<Set<int>>> graph = Map.fromIterable(Iterable<int>.generate(n, (i) => i + 1), value: (i) => [{}, {}]);

    for (List<int> edge in trust) {
      graph[edge[1]]![0].add(edge[0]);
      graph[edge[0]]![1].add(edge[1]);
    }

    for (int key in graph.keys) {
      if (graph[key]![0].length == n - 1 && graph[key]![1].length == 0) {
        return key;
      }
    }

    return -1;
  }
}

/*
Runtime: 386 ms, faster than 100% of Dart online submissions for Find the Town Judge.
Memory Usage: 187.8 MB, less than 33.33% of Dart online submissions for Find the Town Judge.
 */
