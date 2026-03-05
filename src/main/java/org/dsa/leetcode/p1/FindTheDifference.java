package org.dsa.leetcode.p1;

public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifference("asdf","dfsap"));
    }
    public char findTheDifference(String s, String t) {
        int[] arr= new int[26];
        for(char ch : s.toCharArray()){
            arr[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            arr[ch - 'a']--;
        }
        for(int i =0 ; i <26 ; i++){
            if(arr[i] == -1)
                return (char) (i + 'a');
        }
        return '0';
    }
}
