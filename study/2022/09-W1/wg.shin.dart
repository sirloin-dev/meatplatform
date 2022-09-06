class Solution {
  bool wordPattern(String pattern, String s) {
    List<String> strList = s.split(" ");
    List<String> patternList = pattern.split('');
    Map<String, String> memo = {};
    if(strList.length != patternList.length || Set.from(strList).length != Set.from(patternList).length) {
        return false;
    }
    for (int i = 0; i<strList.length; i++){
        if(memo.containsKey(patternList[i]) && memo[patternList[i]] != strList[i]){
            return false;
        }
        memo[patternList[i]] = strList[i];
    }
      return true;
  }
}

/* 
Runtime: 349 ms, faster than 100.00% of Dart online submissions for Word Pattern.
Memory Usage: 143 MB, less than 100.00% of Dart online submissions for Word Pattern.
*/
