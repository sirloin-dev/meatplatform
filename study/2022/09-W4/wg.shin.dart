class Solution {
 bool validPath(int n, List<List<int>> edges, int source, int destination) {
    final Map<int, Set<int>> graph =
        Map<int, Set<int>>.fromIterables(List.generate(n, (i) => i), List.generate(n, (i) => <int>{}));
    for (List<int> edge in edges) {
      graph[edge[0]]!.add(edge[1]);
      graph[edge[1]]!.add(edge[0]);
    }
    final List<int> deque = [];
    final Set<int> memo = {};
    deque.add(source);
    while (deque.isNotEmpty) {
      int currentNode = deque.removeAt(0);
      if (currentNode == destination){
        return true;
      }
      if (memo.contains(currentNode)) {
        continue;
      }
      memo.add(currentNode);
      for (int edge in graph[currentNode]!){
        deque.add(edge);
      }
    }
    return false;
  }
}

/*
Runtime: 2053 ms, faster than 100.00% of Dart online submissions for Find if Path Exists in Graph.
Memory Usage: 237.8 MB, less than 100.00% of Dart online submissions for Find if Path Exists in Graph.
*/
