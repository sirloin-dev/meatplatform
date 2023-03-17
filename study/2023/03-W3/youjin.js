var topKFrequent = function (nums, k) {
  // map 으로 저장
  const numberCount = new Map();

  nums.forEach((num) => {
  // for 문 돌면서 저장한 map 열에 해당하는 num이 있는지 확인
    if (numberCount.has(num)) {
      numberCount.set(num,numberCount.get(num) + 1);
    } else {
      numberCount.set(num, 1);
    }
  });
  // map에 저장해둔 k-v형태를 이중배열로 만들고 v가 큰값대로 정렬
  const sorted = [...numberCount.entries()].sort((a, b) => b[1] - a[1]);

  const answer = [];
  for (let i = 0; i < k; i++) {
  // 정렬한 배열에서 k만 추출
    answer.push(sorted[i][0]);
  }

  return answer;
};
