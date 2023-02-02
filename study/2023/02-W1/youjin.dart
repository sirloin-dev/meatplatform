class Solution {
  int findCheapestPrice(int n, List<List<int>> flights, int src, int dst, int k) {
    final routes = _routes(n, flights);
    final mapped = List.generate(n, (index) => double.maxFinite.toInt());
    mapped[src] = 0;

    final queue = [
      [src, 0, 0]
    ];

    while (queue.isNotEmpty) {
      final shiftQueue = queue.removeAt(0);
      final int now = shiftQueue[0];
      final int totalPrice = shiftQueue[1];
      final int move = shiftQueue[2];

      routes[now].forEach(([int? next, int? price]) => {

        if(price ==null){ price = 0 },

            if (move <= k && totalPrice + price < mapped[next!]){
                mapped[next] = totalPrice + price,
                queue.add([next, totalPrice + price, move + 1]),
              }
          });
    }

    return mapped[dst] != double.maxFinite.toInt() ? mapped[dst] : -1;
  }

  _routes(int n, List<List<int>> flights) {
    final list = List.generate(n, (index) => []);

    for (var ele in flights) {
      list[ele[0]].add([ele[1], ele[2]]);
    }

    return list;
  }
}
