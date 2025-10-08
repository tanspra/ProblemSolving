package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
  public static void main(String[] args) {
    //    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    //    int[][] intervals = {{1, 4}, {0, 0}};
    //    int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};
    int[][] intervals = {{2, 3},
        {4, 5},
        {6, 7},
        {8, 9},
        {1, 10}};
    int[][] mergedIntervals = new MergeIntervals().merge(intervals);
    System.out.println(Arrays.deepToString(mergedIntervals));
  }
  
  public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1) return intervals;
    //sort array element on the basis of start interval
    Arrays.sort(intervals,(a,b)->(Integer.compare(a[0], b[0])));
    
    List<int[]> merged = new ArrayList<>();
    int[] current = intervals[0];
    
    for (int i = 1; i < intervals.length; i++) {
      int[] next = intervals[i];
      if(current[1] >= next[0]){
        current[1] = Math.max(current[1],next[1]);
      }else{
        merged.add(current);
        current = next;
      }
      
    }
    
    merged.add(current);
    return merged.toArray(new int[merged.size()][]);
  }
  
  //  public int[][] merge(int[][] intervals) {
//    int i = 0;
//    while (i < intervals.length - 1) {
//      int[] currentInterval = intervals[i];
//      int[] nextInterval = intervals[i + 1];
//      if (currentInterval[1] >= nextInterval[0] && nextInterval[1] >= currentInterval[0]) {
//        intervals = mergeAndReduce(intervals, i, i + 1);
//      } else {
//        i++;
//      }
//    }
//    return intervals;
//  }
//
//  private int[][] mergeAndReduce(int[][] intervals, int current, int next) {
//    int[] currentInterval = intervals[current];
//    int[] nextInterval = intervals[next];
//    currentInterval[0] = currentInterval[0] <= nextInterval[0] ? currentInterval[0] : nextInterval[0];
//    currentInterval[1] = currentInterval[1] >= nextInterval[1] ? currentInterval[1] : nextInterval[1];
//    intervals[current] = null;
//    intervals[next] = currentInterval;
//    for (int i = next; i < intervals.length; i++) {
//      intervals[i - 1] = intervals[i];
//    }
//    intervals[intervals.length - 1] = null;
//    int[][] newintervals = new int[intervals.length - 1][];
//    int index = 0;
//    for (int[] val : intervals) {
//      if (val != null) {
//        newintervals[index] = val;
//        index++;
//      }
//    }
//    return newintervals;
//  }
}
