package string;

import java.util.Arrays;
import java.util.List;

public class _36Decimal {

    private static List<Character> tableList;

    static {
        Character[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        tableList = Arrays.asList(table);
    }

    public static void main(String[] args) {
        String a1 = "10";
        String a2 = "11";
        System.out.println(thirtySixDecimal(a1, a2));
    }

    private static String thirtySixDecimal(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder ansBuilder = new StringBuilder();
        int carry = 0;
        while(i >= 0 && j >= 0) {
            int num1 = tableList.indexOf(a.charAt(i));
            int num2 = tableList.indexOf(b.charAt(j));
            int sum = num1 + num2 + carry;
            if (sum >= 36) {
                carry = 1;
                ansBuilder.append(tableList.get(sum % 36));
            } else {
                carry = 0;
                ansBuilder.append(tableList.get(sum));
            }
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = tableList.indexOf(a.charAt(i)) + carry;
            if (sum >= 36) {
                carry = 1;
                ansBuilder.append(tableList.get(sum % 36));
            } else  {
                carry = 0;
                ansBuilder.append(tableList.get(sum));
            }
        }

        while (j >= 0) {
            int sum = tableList.indexOf(b.charAt(j)) + carry;
            if (sum >= 36) {
                carry = 1;
                ansBuilder.append(tableList.get(sum % 36));
            } else  {
                carry = 0;
                ansBuilder.append(tableList.get(sum));
            }
        }

        if (carry > 0) {
            ansBuilder.append('1');
        }

        return ansBuilder.reverse().toString();
    }
}
