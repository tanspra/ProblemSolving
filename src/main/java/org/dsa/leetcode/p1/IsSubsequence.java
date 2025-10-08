package org.dsa.leetcode.p1;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("axa", "aab"));
    }

    public boolean isSubsequence(String s, String t) {
       int i =0, j=0;
       while(i < s.length() && j < t.length()){
           if(s.charAt(i) == t.charAt(j)) i++;
           j++;
       }
       return i == s.length();
    }

//    private boolean subsequencehelper(String p, String up, String target) {
//
//           if(up.equals(target))
//               return true;
//
//        if(p.length() > 0){
//            char c = p.charAt(0);
//            if(subsequencehelper(p.substring(1), up + c, target))
//                return true;
//            if(subsequencehelper(p.substring(1), up, target))
//                return true;
//        }
//        return false;
//    }
//
//    private void subsequencehelper2(String p, String up, Set<String> set) {
//        if(p.length() == 0){
//            set.add(up);
//            return;
//        }
//        char c = p.charAt(0);
//        subsequencehelper2(p.substring(1), up + c, set);
//        subsequencehelper2(p.substring(1), up, set);
//    }
}
