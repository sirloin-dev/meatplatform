// 146. LRU Cache

/*
실무에서 사용했었던 코드가 있어서 그대로 구현해봤을때.
*/
class LRUCache {
  final Map<int, CacheEntry> _map = {};
  final int capacity;

  LRUCache(this.capacity);

  int get(int key) {
    if (_map.containsKey(key)) {
      _map[key]!.stamp = DateTime.now();
      return _map[key]!.value;
    }
    return -1;
  }

  void put(int key, int value) {
    if (_map.containsKey(key)) {
      _map[key]!.stamp = DateTime.now();
      _map[key]!.value = value;
      return;
    }
    if (_map.length >= capacity) {
      List<CacheEntry> values = _map.values.toList();
      values.sort((a, b) => b.stamp.compareTo(a.stamp));
      _map.remove(values.last.key);
    }

    _map[key] = CacheEntry(
      key: key,
      value: value,
      stamp: DateTime.now(),
    );
    print(_map);
  }
}

class CacheEntry {
  final int key;
  int value;
  DateTime stamp;

  CacheEntry({
    required this.key,
    required this.value,
    required this.stamp,
  });

  @override
  String toString() => """{$value, $stamp}""";
}
/*
정확도는 만족하지만, 시간복잡도를 통과하지 못한다.

solution 을 참조하니 double linkedList 를 이용해 구현한다고 한다.
*/

// Solution
class LRUCache {
  final CacheEntry _head = CacheEntry(key: 0, value: 0);
  final CacheEntry _tail = CacheEntry(key: 0, value: 0);
  final Map<int, CacheEntry> _map = {};
  final int capacity;

  LRUCache(this.capacity) {
    _head.next = _tail;
    _tail.prev = _head;
  }

  void _remove(CacheEntry entry) {
    _map.remove(entry.key);
    entry.prev!.next = entry.next;
    entry.next!.prev = entry.prev;
  }

  void _insert(CacheEntry entry) {
    _map[entry.key] = entry;
    CacheEntry headNext = _head.next!;
    headNext.prev = entry;
    entry.next = headNext;
    _head.next = entry;
    headNext.prev = entry;
    entry.prev = _head;
  }

  int get(int key) {
    if (!_map.containsKey(key)) {
      return -1;
    }
    CacheEntry entry = _map[key]!;
    _remove(entry);
    _insert(entry);
    return entry.value;
  }

  void put(int key, int value) {
    if (_map.containsKey(key)) {
      _remove(_map[key]!);
    }
    if (_map.length >= capacity) {
      _remove(_tail.prev!);
    }
    _insert(CacheEntry(key: key, value: value));
  }
}

class CacheEntry {
  CacheEntry? prev;
  CacheEntry? next;
  final int key;
  int value;

  CacheEntry({
    required this.key,
    required this.value,
    this.prev,
    this.next,
  });

  @override
  String toString() => "$value";
}
/*
조금.. 빡쌨던 문제.

정확도를 구현하는건 문제가 크게 없었는데, O(1) 안에 read 와 put 을 구현하는 방법의 수단이 더블 링크드 리스트로 이어지지 못했다.
*/
