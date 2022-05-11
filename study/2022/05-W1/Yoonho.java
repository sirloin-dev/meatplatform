import java.util.HashMap;
import java.util.Map;

public class Yoonho {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Yoonho().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public String longestCommonPrefix(String[] strs) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < str.length(); j++) {
                String target = str.substring(0, j + 1);
                if (map.containsKey(target)) {
                    map.put(target, map.get(target) + 1);
                } else {
                    map.put(target, 0);
                }
            }
        }

        String answer = "";
        int length = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == strs.length - 1) {
                if (length < key.length()) {
                    length = key.length();
                    answer = key;
                }
            }
        }

        return answer;
    }
}
