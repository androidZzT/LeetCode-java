package string;

import java.util.Arrays;

public class ReverseWord {

    public static void main(String[] args) {
        String target = "I am a Boy";
        System.out.println(reverse(target));
    }

    private static String reverse(String target) {
        String[] words = target.split(" ");
        int i = 0;
        int j = words.length - 1;
        while (i < j) {
            String temp  = words[i];
            words[i] = words[j];
            words[j] = temp;

            i++;
            j--;
        }
        return Arrays.toString(words);
    }
}
