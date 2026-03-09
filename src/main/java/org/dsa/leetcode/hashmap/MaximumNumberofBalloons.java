package org.dsa.leetcode.hashmap;

import java.util.HashMap;

public class MaximumNumberofBalloons {
    public static void main(String[] args) {
        System.out.println(new MaximumNumberofBalloons().maxNumberOfBalloons("loonbalxballpoon"));
    }
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(char c : text.toCharArray()){
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }
        int bCount = hashMap.getOrDefault('b',0);
        int aCount = hashMap.getOrDefault('a',0);
        int lCount = hashMap.getOrDefault('l',0);
        int oCount = hashMap.getOrDefault('o',0);
        int nCount = hashMap.getOrDefault('n',0);
        lCount = lCount/2;
        oCount = oCount/2;
        return Math.min(aCount, Math.min(bCount, Math.min(lCount, Math.min(oCount, nCount))));

    }
}
