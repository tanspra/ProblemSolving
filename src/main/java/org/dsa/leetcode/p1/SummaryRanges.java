package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
//        List<String> strings = new SummaryRanges().summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        List<String> strings = new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        System.out.println(strings.toString());
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int start = i;
            while (i + 1 < n && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            if (start == i) {
                res.add(nums[i] + "");
            } else {
                res.add(nums[start]+"->"+nums[i]);
            }
            i++;
        }
        return res;
    }
}
