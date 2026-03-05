package org.dsa.leetcode.p1;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    public MyStack() {

    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if (queue1.isEmpty())
            throw new RuntimeException("Stack is empty!");
        return queue1.poll();
    }

    public int top() {
        if (queue1.isEmpty())
            throw new RuntimeException("Stack is empty!");
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}