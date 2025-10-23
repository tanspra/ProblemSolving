package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.List;

public class Pascalstriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 1){
            triangle.add(List.of(1));
            return triangle;
        }else if(numRows ==2){
            triangle.add(List.of(1));
            triangle.add(List.of(1,1));
            return triangle;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j ==0 || j==i){
                    row.add(1);
                }else{
                   int val = triangle.get(i-1).get(j-1) +  triangle.get(i-1).get(j);
                   row.add(val);
                }
            }
            triangle.add(row);
        }
        return triangle;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        int ans = 1;
        res.add(ans);
        for(int i = 1 ; i<= rowIndex; i++){
            ans *= (rowIndex-i);
            ans /= i;
            res.add(ans);
        }
        return res;
    }
}
