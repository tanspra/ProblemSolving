package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
  public static void main(String[] args) {
//    int[][] intervals = {{1, 3}, {6, 9}};
//    int[] newIntervals = {2, 5};
    int[][] intervals = {{2,3},{6,9}};
    int[] newIntervals = {0, 1};
    int[][] mergedIntervals = new InsertIntervals().insert(intervals, newIntervals);
    System.out.println(Arrays.deepToString(mergedIntervals));
  }
  
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> merged = new ArrayList<>();
    
    //empty interval
    if(intervals.length == 0 ){
      merged.add(newInterval);
      return merged.toArray(new int[merged.size()][]);
    }
    for (int i = 0; i < intervals.length; i++) {
      int[] current = intervals[i];
      if(null != newInterval &&newInterval[1] < current[0]){
        merged.add(newInterval);
        newInterval = null;
      }
      if (newInterval != null && current[1] >= newInterval[0] && current[0] <= newInterval[1]) {
        newInterval[0] = Math.min(current[0], newInterval[0]);
        newInterval[1] = Math.max(current[1], newInterval[1]);
      } else {
        merged.add(current);
      }
    }
    if(newInterval != null){
      merged.add(newInterval);
    }
    
    return merged.toArray(new int[merged.size()][]);
  }
}
