package cn.wjs.daimazhinan.chapter5;

public class isDeformation {
    public static void main(String[] args) {
        String str1 = "abca";
        String str2 = "acba";
        System.out.println(isDeformation(str1, str2));
    }

    public static boolean isDeformation(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[] num = new int[256];
        for (int i = 0; i < c1.length; i++) {
            num[c1[i]]++;
        }
        for (int i = 0; i < c2.length; i++) {
            System.out.println(num[c2[i]]);
            if (num[c2[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }
}
