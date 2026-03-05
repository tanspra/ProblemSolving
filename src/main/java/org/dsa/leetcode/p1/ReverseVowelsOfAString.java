package org.dsa.leetcode.p1;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        if (s.length() <= 1)
            return s;
        int left = 0, right = s.length() - 1;
        do {
            while (left<right && !isVowel(s.charAt(left)))
                left++;
            while (left<right && !isVowel(s.charAt(right)))
                right--;
            if (left == right)
                return s;
            char ch = s.charAt(left);
            StringBuffer sb = new StringBuffer(s);
            sb.setCharAt(left, s.charAt(right));
            sb.setCharAt(right, ch);
            s = sb.toString();
            left++;
            right--;
        }
        while (left < right);
        return s;
    }

    private boolean isVowel(char ch) {
        return "AEIOUaeiou".indexOf(ch) != -1;
    }
}
