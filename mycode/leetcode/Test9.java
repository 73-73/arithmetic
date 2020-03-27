package mycode.leetcode;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author pan
 * @create 2019-11-26-9:05
 */
public class Test9 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(123);
        boolean palindrome2 = isPalindrome(232);
        boolean palindrome3 = isPalindrome(0);
        boolean palindrome4 = isPalindrome(1221);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;
        else {
            String s = String.valueOf(x);
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            }
            return true;
        }
    }
}
