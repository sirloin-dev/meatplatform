import java.util.HashMap;
import java.util.Stack;

public class yoonho {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');

        for(int i = 0 ; i < s.length() ; i++){
            char chr = s.charAt(i);
            if(chr == '(' || chr == '[' || (chr == '{' )) stack.push(chr);
            else {
                if(!stack.empty() && stack.peek() == map.get(chr)) stack.pop();
                else return false;
            }
        }

        return stack.empty();
    }
}
