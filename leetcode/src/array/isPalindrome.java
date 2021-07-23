package array;

/**
 * 回文数
 */
public class isPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1111));
    }

    private static boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x % 10 == 0) return false; 
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        System.out.println("x=" + x + ",reverse=" + reverse);
        return x == reverse || x  == reverse / 10; //奇数位需要再次
    }
}
