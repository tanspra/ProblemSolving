package org.dsa.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
