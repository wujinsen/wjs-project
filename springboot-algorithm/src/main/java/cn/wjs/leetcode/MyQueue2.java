package cn.wjs.leetcode;

import java.util.Stack;

public class MyQueue2 {

    Stack<Integer> s1;

    Stack<Integer> s2;

    private int front;

    /**
     * 入队
     * @param x
     */
    public void push(int x) {
        if (s1.empty()) {
            front = x;
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

}
