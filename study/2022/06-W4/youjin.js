const searchInsert = function(nums, target) {
    const latest = nums.length-1;
    let left = 0;
    let right = latest;
   
    if(nums[latest] < target) return latest+1;
    else if(nums[0] > target) return 0;
   
    let answer = -1;
   
    while(left <= right) {
        const i = left + Math.floor((right - left) / 2);
       
        if(nums[i] < target) {
            answer = Math.max(answer, i);
            left = i+1;
        } else {
            right = i-1;
        };
    }
    return answer+1;
};

// Success

// Runtime: 74 ms, faster than 68.12% of JavaScript online submissions for Search Insert Position.
// Memory Usage: 42.2 MB, less than 58.11% of JavaScript online submissions for Search Insert Position.
