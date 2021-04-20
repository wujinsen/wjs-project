package cn.wjs.suanfa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class stringrepeat {

    public static void main(String[] args) {
        String str = "aaabbbccc";
        System.out.println(str);
        List list  = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println(list);
    }
    public String removeRepeatChar(String str) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i ++) {

            char charWord = str.charAt(i);

            int firstPosition = str.indexOf(charWord);

            int lastPosition = str.lastIndexOf(charWord);

            if (firstPosition  == lastPosition || firstPosition == i) {

                sb.append(charWord);//

            }
        }
        return sb.toString();
    }
}
