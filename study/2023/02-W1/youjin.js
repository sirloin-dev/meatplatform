const findCheapestPrice = (n, flights, src, dst, k) => {
  const routes = _routes(n, flights);

  const mapped = Array.from({ length:n }, () => Number.MAX_SAFE_INTEGER);
  
  mapped[src] = 0;
  const queue = [[src, 0, 0]];
    
  while (queue.length > 0) {
      const [now, totalPrice, move] = queue.shift();

    routes[now].forEach(([next, price]) => {
      if (move <= k && totalPrice + price < mapped[next]) {
        mapped[next] = totalPrice + price;
        queue.push([next, totalPrice + price, move + 1]);
      }
    })
  };
  
  return mapped[dst] !== Number.MAX_SAFE_INTEGER ? mapped[dst] : -1;
};

const _routes = (n, flights) => {
	const arr = Array.from({ length: n }, () => []);
  
	flights.forEach((flight) => {
		const [start, end, price] = flight;
		arr[start].push([end, price]);
	});
  
	return arr;
};


// Runtime 102 ms
// Beats 74.52%
// Memory 46 MB
// Beats 74.90%
