package org.dsa.leetcode.twopointer;

public class BackspaceStringCompare {
    public static void main(String[] args) {
//        System.out.println(new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new BackspaceStringCompare().backspaceCompare("isfcow#", "isfco#w#"));
    }

    private boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int skipS = 0, skipT = 0;
        while(i >= 0 || j >= 0){
            while(i>= 0){
                if(s.charAt(i) == '#'){
                    skipS++;
                    i--;
                }else if(skipS > 0){
                    skipS--;
                    i--;
                }else {
                    break;
                }
            }

            while(j >= 0 ){
                if(t.charAt(j) == '#'){
                    skipT++;
                    j--;
                }else if(skipT > 0){
                    skipT--;
                    j--;
                }else{
                    break;
                }
            }
            if(( i >= 0 && j >= 0) && (s.charAt(i) != t.charAt(j))){
                return false;
            }
            if((i >= 0) != (j>= 0)){
                return false;
            }
        }
        return true;
    }

    public boolean backspaceCompare1(String s, String t) {
        s = processbackspace(s);
        t = processbackspace(t);
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }else{
                return false;
            }
        }
        if(i != s.length() || j != t.length())
            return false;
        return true;
    }

    private String processbackspace(String s) {
        int low = 0, high = s.length() - 1, count = 0;
        StringBuffer sb = new StringBuffer();
        while (low <= high) {
            char ch = s.charAt(high);
            if (ch == '#') {
                count++;
            } else if (ch != '#') {
                if (count == 0) {
                    sb.append(ch);
                } else {
                    count--;
                }
            }
            high--;
        }
        return sb.reverse().toString();
    }
}
