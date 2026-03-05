package org.dsa.leetcode.p1;

import java.util.Stack;

public class MyQueue {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.peek();
        myQueue.pop();
        myQueue.pop();
        System.out.println(myQueue.empty());
    }
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty())
            throw new RuntimeException("stack is Empty");
        Integer pop = stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return pop;
    }

    public int peek() {
        Stack<Integer> temp = (Stack<Integer>) stack1.clone();
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1 = temp;
        if (stack2.isEmpty())
            throw new RuntimeException("stack is Empty");
        int peek= stack2.peek();
        stack2 = new Stack<>();
        return peek;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}

