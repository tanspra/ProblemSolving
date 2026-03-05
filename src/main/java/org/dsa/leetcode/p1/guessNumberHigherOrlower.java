package org.dsa.leetcode.p1;

public class guessNumberHigherOrlower {
    public int guessNumber(int n) {
        int left = 0, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            switch (guess(mid)) {
                case 0:
                    return mid;
                case -1:
                    right = mid - 1;
                    break;
                case 1:
                    left = mid + 1;
                    break;
            }
        }
        return 0;
    }

    private int guess(int mid) {
        return 0;
    }


}
