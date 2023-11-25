package org.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring(String s) {
//        Set<Character> charSet = new HashSet<>();
//        int max=0,current=0;
//        for(Character ch : s.toCharArray()){
//            if(charSet.contains(ch)){
//               charSet=new HashSet<>();
//               if(current>max){
//                   max=current;
//               }
//               current=1;
//            }else{
//                charSet.add(ch);
//                current++;
//            }
//
//        }
//        return max>current?max:current;

        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }
}
