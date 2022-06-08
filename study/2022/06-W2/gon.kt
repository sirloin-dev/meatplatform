/*
        1. 먼저 예외조건을 전부 얼리리턴합니다 처음비교시 같을때 or needle이 공백일때
        2. haystack의 인덱스 i의 needle의 숫자만큼 더해서 haystack에서 string 을 가져운후 비교합니다
*/
    fun strStr(haystack: String, needle: String): Int {
        if(needle.isEmpty()){ return -1 }
        if (haystack == needle){ return 0}
        for (i in haystack.indices){
            if((i + needle.length -1) > (haystack.length - 1)){
                return -1
            }
            var str =""
            for (k in needle.indices){
                str += haystack[i+k]
            }
            if (needle == str){
                return i
            }
        }
        return -1
    }
