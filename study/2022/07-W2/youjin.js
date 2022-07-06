const merge = function (nums1, m, nums2, n) {
  nums1.splice(m, n, ...nums2);
  nums1.sort((a, b) => a - b);
  return nums1;
};

// Success ---
// Runtime: 71 ms, faster than 79.61% of JavaScript online submissions for Merge Sorted Array.
// Memory Usage: 41.9 MB, less than 82.63% of JavaScript online submissions for Merge Sorted Array.
