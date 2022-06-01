class Solution {
    public int strStr(String haystack, String needle) {
        int needleSize = needle.length();
        int stackSize = haystack.length();
        char firstNeedle = needle.charAt(0);
            
        if(needleSize > stackSize) return -1;
        
        for(int i = 0 ; i < haystack.length() ; i++) {
            if(i + needleSize > stackSize) return -1;
            if(haystack.charAt(i) == firstNeedle){
                if(haystack.substring(i, i + needleSize).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
