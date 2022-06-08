const strStr = (haystack, needle) => {
    if (!needle.length) return 0
    outer:for(let i = 0 ; i < haystack.length; i++) {
        if (haystack.length - i < needle.length) break
        for(let j = 0 ; j < needle.length; j++) {
            if(haystack[j + i] !== needle[j]) continue outer
        }
        return i
    }
    return -1
};

// Runtime: 63 ms, faster than 87.01% of JavaScript online submissions for Implement strStr().
// Memory Usage: 41.7 MB, less than 84.53% of JavaScript online submissions for Implement strStr().
