const longestCommonPrefix = function(strs) {
  // strs 배열에 요소가 없으면 빈 문자열을 return 한다.
    if(!strs.length){ 
        return '';
    }else{
      // strs 배열의 첫번째 요소의 문자열들 길이만큼 반복하여 비교해본다. 어짜피 이 문자열안에서만 반복되는 문자가 있을 거니까.
        for(let i = 0; i < strs[0].length; i++) {
          // for...of 를 사용해서 strs 파라미터의 요소들을 str으로 가져온다.
          for(let str of strs) {
            if(str[i] !== strs[0][i]) {
                return str.slice(0, i);
            }
        }
    }   
        return strs[0];
    }
};

// longestCommonPrefix(['fly', 'float', 'flower']);
// i => 0,1,2
// str => 'fly', 'float', 'flower'
// strs[0][i] => 'f', 'l', 'y'
