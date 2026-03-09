package org.dsa.leetcode.binarysearchalgo;

public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int eatingSpeed = 1;
        int low = 1, high = maxOfArray(piles);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalTimeTaken = findTotalTime(piles, mid);
            if (totalTimeTaken > h) {
                low = mid + 1;
            } else {
                eatingSpeed = mid;
                high = mid - 1;
            }
        }
    return eatingSpeed;
    }

    private long findTotalTime(int[] piles, int speed) {
        long timeTaken = 0;
        for (int pile : piles) {
            timeTaken += pile / speed;
            if (pile % speed != 0) timeTaken++;
        }
        return timeTaken;
    }

    private int maxOfArray(int[] piles) {
        int max = piles[0];
        for (int val : piles) {
            if (val > max) max = val;
        }
        return max;
    }
}
