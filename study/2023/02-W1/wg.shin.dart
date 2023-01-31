import 'dart:collection';

/*
Runtime: 326 ms
Beats 100%
----------
Memory
164.6 MB
Beats 20%
* */

class Solution {
  static const int INT_MAX = 2147483647;
  final Map<int, Map<int, int>> _map = {};
  int _ans = INT_MAX;
  final Map<int, int> _memo = {};

  void _makeAllNode(int n) {
    for (int i = 0; i < n; i++) {
      _map[i] = {};
    }
  }

  void _initializeMap(int n, List<List<int>> flights) {
    for (final List<int> edge in flights) {
      final int start = edge[0];
      final int end = edge[1];
      final int cost = edge[2];
      // dart 3 의 패턴매칭이 있었으면 코드가 짧아졌을탠데.

      _map[start]![end] = cost;
    }
  }

  void _addLinkedNode(int k, int des, Queue<QueueUnit> queue, QueueUnit current) {
    if (current.stopCounter > k) {
      return;
    }
    if (current.currentNode == des && _ans > current.currentCost) {
      _ans = current.currentCost;
      return;
    }

    if (_memo.containsKey(current.currentNode) && _memo[current.currentNode]! < current.currentCost) {
      return;
    }

    _memo[current.currentNode] = current.currentCost;

    _map[current.currentNode]?.forEach((key, value) {
      final int nextNode = key;
      final int cost = value;
      queue.add(QueueUnit(
        currentCost: current.currentCost + cost,
        currentNode: nextNode,
        stopCounter: current.stopCounter + 1,
      ));
    });
  }

  void _bfs(int start, int des, int k) {
    Queue<QueueUnit> queue = Queue();
    _addLinkedNode(k, des, queue, QueueUnit(currentCost: 0, currentNode: start, stopCounter: -1));

    while (queue.isNotEmpty) {
      QueueUnit current = queue.removeFirst();
      _addLinkedNode(k, des, queue, current);
    }
  }

  int findCheapestPrice(int n, List<List<int>> flights, int src, int dst, int k) {
    _makeAllNode(n);
    _initializeMap(n, flights);
    _bfs(src, dst, k);
    return _ans == INT_MAX ? -1 : _ans;
  }
}

class QueueUnit {
  final int currentCost;
  final int currentNode;
  final int stopCounter;

  const QueueUnit({
    required this.currentCost,
    required this.currentNode,
    required this.stopCounter,
  });
}
