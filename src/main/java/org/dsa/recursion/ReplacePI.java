package org.dsa.recursion;

public class ReplacePI {
    public static void main(String[] args) {
        String str = "abcdefghpiabcppi";
        System.out.println(replacePi(str,0));
    }
    static String replacePi(String s, int index){
        int subLen = s.substring(index).length();
        if(subLen == 0 || subLen == 1)
            return s;
        if(s.charAt(index) == 'p' && s.charAt(index+1) == 'i'){
            return replacePi(s.replace("pi","3.14"),4);
        }
        else{
            return replacePi(s,index+1);
        }
    }
}
