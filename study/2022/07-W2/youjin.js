const merge = function (nums1, m, nums2, n) {
  nums1.splice(m, n, ...nums2);
  nums1.sort((a, b) => a - b);
  return nums1;
};

// 2022.07.08 금요일 피드백 -> n * logN :: 비효율적이다. + 코드 가독성은 좋다. sort 최적화를 하면 더 좋은 방안이 될 것 같다.

// Success ---
// Runtime: 71 ms, faster than 79.61% of JavaScript online submissions for Merge Sorted Array.
// Memory Usage: 41.9 MB, less than 82.63% of JavaScript online submissions for Merge Sorted Array.
