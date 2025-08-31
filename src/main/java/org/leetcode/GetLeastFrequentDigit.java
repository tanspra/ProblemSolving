package org.leetcode;

import java.util.HashMap;
import java.util.Map;

public class GetLeastFrequentDigit {
    public int getLeastFrequentDigit(int n) {
        Map<Integer,Integer> map = new HashMap();
        while(n > 0){
            int rem = n%10;
            if(map.containsKey(rem)){
                map.put(rem, map.get(rem)+1);
            }else{
                map.put(rem,1);
            }
            n= n/10;
        }
        Integer key = map.entrySet().stream().min((e1, e2) -> e1.getValue() - e2.getValue()).get().getKey();
        return key;
    }
}
