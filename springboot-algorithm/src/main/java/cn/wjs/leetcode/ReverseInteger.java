package cn.wjs.leetcode;

/**
 * 反转数字
 * 输入：x = 123
 * 输出：321
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(234 / 10);
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;//末尾数
            x /= 10;//没有末尾数的剩余值
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;

        }
        return rev;
    }
}
