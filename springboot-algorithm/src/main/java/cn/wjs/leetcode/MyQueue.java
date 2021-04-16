package cn.wjs.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用栈实现队列
 *
 * 将一个栈当作输入栈，用于压入
 * push
 * push 传入的数据；另一个栈当作输出栈，用于
 * pop
 * pop 和
 * peek
 * peek 操作。
 *
 * 每次
 * pop
 * pop 或
 * peek
 * peek 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
 *
 */
public class MyQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
      //  System.out.println(queue.pop());
    }
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    /**
     * 入队
     *
     * @param x
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * 出队
     *
     * @return
     */
    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }


    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

}
