package cn.wjs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(test(list, 2));
    }

    public static int test(List<Integer> list, int m) {
        if (list.size() == 1) {
            return list.get(0);
        } else {
            int deleteFlag = 0;
            deleteFlag = deleteFlag + m;
            list.remove(deleteFlag);
            return test(list, deleteFlag);
        }
    }
}

