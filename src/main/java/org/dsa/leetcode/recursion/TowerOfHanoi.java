package org.dsa.leetcode.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        solve(10,'A', 'C', 'B');
    }
    static void solve(int n, char source, char destination, char auxiliary){
        if(n == 1){
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        solve(n-1,source,auxiliary,destination);
        System.out.println("Move disk "+ n +" from " + source + " to " + destination);
        solve(n-1,auxiliary,destination,source);
    }
}
