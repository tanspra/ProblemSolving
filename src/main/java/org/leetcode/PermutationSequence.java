package org.leetcode;

import java.util.ArrayList;

public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3,3));
    }
    public static int fact(int n)
    {
        if(n<=1)
        {
            return 1;
        }
        return n*fact(n-1);
    }
    public String getPermutation(int n, int k) {
        k--;
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        StringBuilder result= new StringBuilder();
        for(int i=1;i<=n;i++)
        {
            int fg=fact(list.size()-1);
            int index=k/fg;
            result.append(list.get(index));
            list.remove(index);
            k=k%fg;
        }
        return result.toString();
    }
}
