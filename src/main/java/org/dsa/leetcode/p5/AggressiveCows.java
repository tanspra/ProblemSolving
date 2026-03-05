package org.dsa.leetcode.p5;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        System.out.println(new AggressiveCows().aggressiveCows(new int[]{6, 4, 3, 16, 20, 7, 18, 10}, 5));
    }

    public int aggressiveCows(int[] stalls, int k) {
        int ans = Integer.MIN_VALUE;
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 0, high = stalls[n-1] - stalls[0];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValidCowArrangement(stalls, k, mid)) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isValidCowArrangement(int[] stalls, int k, int guess) {
        int cows = 1;
        int prevPos = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - prevPos < guess)
                continue;
            cows++;
            prevPos = stalls[i];
        }
        if (cows >= k) {
            return true;
        } else {
            return false;
        }
    }
}
