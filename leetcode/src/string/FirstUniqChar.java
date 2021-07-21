package string;

import java.util.HashMap;

public class FirstUniqChar {

    public static void main(String[] args) {
        int ans = firstUniqChar("google");
        System.out.println("ans=" + ans);
    }

    private static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);
            if (index != null) {
                index++;
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        System.out.println("map="+ map);
        int ans = -1;
        for (int j = 0; j < s.length(); j++) {
            int index = map.get(s.charAt(j));
            if (index != -1) {
                ans = index;
                break;
            }
        }
        return ans;
    }
}
