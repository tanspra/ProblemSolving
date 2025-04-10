package org.leetcode.easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String str = "Hello world! how are you ";
        System.out.println(lengthOfLastWord(str));
    }

    public static int lengthOfLastWord(String s) {
        String[] splitArr = s.split(" ");
        return s.split(" ")[s.split(" ").length - 1].length();
    }
}
