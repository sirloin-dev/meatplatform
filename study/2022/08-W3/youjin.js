const solution = function(isBadVersion) {
    return function(n) {
        let min = n
        let left = 0;
        let right = n-1;
        
        while(left <= right) {
            const i = left + Math.floor((right - left) / 2)
        
            if (isBadVersion(i+1)) {
                min = Math.min(min, i)
                right = i-1
            } else left = i+1
        }
        return min + 1
    };
};

// Success

// Runtime: 69 ms, faster than 83.17% of JavaScript online submissions for First Bad Version.
// Memory Usage: 41.7 MB, less than 68.41% of JavaScript online submissions for First Bad Version.
