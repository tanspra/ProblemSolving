package org.dsa.leetcode.stack;

import java.util.List;
import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {
    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesinStringII().removeDuplicates("abbacd", 2));
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().ch != ch) {
                stack.push(new Pair(ch, 1));
            } else if (stack.peek().ch == ch) {
                if (stack.peek().count == k - 1) {
                    stack.pop();
                } else {
                    Pair pop = stack.pop();
                    stack.push(new Pair(pop.ch, pop.count + 1));
                }
            }
        }
        List<Pair> list = stack.stream().toList();
        StringBuilder sb = new StringBuilder();
        for (Pair pair : list) {
            for (int i = 0; i < pair.count; i++) {
                sb.append(pair.ch);
            }
        }
        return sb.toString();
    }

    record Pair(char ch, int count) {
    }
}
