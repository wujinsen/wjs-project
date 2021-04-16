package cn.wjs.leetcode;

/***
 * 回文数-字符串
 */
public class PalindromeString {

    public static void main(String[] args) {

        System.out.println(validPalindrome("12321"));
    }
    public static  boolean validPalindrome(String s) {
        int n = s.length();
        for (int left = 0, right =  n-1; left < right; ++left, --right) {
            char c1 = s.charAt(left), c2 = s.charAt(right);
            if (c1 != c2) {
                return false;
            }
        }
        return true;

    }
}
