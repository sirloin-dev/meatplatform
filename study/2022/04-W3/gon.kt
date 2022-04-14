class Solution {
    /*
        1. 주어진 문자열을 String[]로 만듭니다.
        2. String[]을 순차적으로 스택에 넣습니다
        3. 스택에 넣는 순간 스택의 마지막과 현재 넣는 괄호가 페어를 이루면 스택에서 삭제하고 현재괄호도 삭제합니다.
        4. String[]의 반복문이 다 돌고 스택이 비어있다면 true 아니면 false 반환 합니다.
        ==============================
        괄호가 안닫힌걸 에외로 던져서 잡아서 처리하는게 좋은 방법일까? 에 대한 고민
        
    */
      fun isValid(s: String): Boolean {
        try{
            val stack = ArrayDeque<String>()
            for (bracket in s.toCharArray().map { c -> c.toString() }) {
                if (stack.isNotEmpty() && bracket == bracketPair(stack.last())){
                    stack.removeLast()
                }else{
                    stack.addLast(bracket)
                }
            }
            return stack.isEmpty()
        }catch(e : Exception){
            return false
        }
       
    }

    fun bracketPair(bracket: String): String =
        when(bracket) {
            "(" -> ")"
            "[" -> "]"
            "{" -> "}"
             else -> throw Exception("페어를 이루지 못한 괄호가 스택에 있습니다.")
        }
}
