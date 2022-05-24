/*
Runtime: 75 ms, faster than 89.50% of JavaScript online submissions for Remove Duplicates from Sorted Array.
Memory Usage: 45.1 MB, less than 21.40% of JavaScript online submissions for Remove Duplicates from Sorted Array.
*/
const removeDuplicates = (nums) => {nums.splice(0, nums.length, ...(new Set(nums)))};
// 한줄로 풀 수 있을꺼 같아서 풀어봤습니다.
// 처음에는 map으로도 될 줄 알았는데 splice를 쓰지 않으면 원본 객체가 변경되지 않더군요.
