package org.dsa.leetcode.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
    public static void main(String[] args) {
//        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
//        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
//        int[][] firstList = {{8,15}};
//        int[][] secondList = {{2,6},{8,10},{12,20}};
        int[][] firstList = {
                {3, 5},
                {9, 20}
        };
        int[][] secondList = {
                {4, 5},
                {7, 10},
                {11, 12},
                {14, 15},
                {16, 20}
        };
        System.out.println(Arrays.deepToString(new IntervalListIntersections().intervalIntersection(firstList, secondList)));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length){
            int start1 = firstList[i][0], end1 = firstList[i][1];
            int start2 = secondList[j][0], end2 = secondList[j][1];
            if(start1 <= start2){
                if(end1 >= start2){
                    result.add(new int[]{Math.max(start1, start2), Math.min(end1, end2)});
                }
            }else{
                if(end2 >= start1){
                    result.add(new int[]{Math.max(start2, start1), Math.min(end2, end1)});
                }
            }
            if(end1 <= end2){
                i++;
            }else{
                j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
