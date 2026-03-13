package org.dsa.leetcode.slowandfastpointer;

public class CircularArrayLoop {
    public static void main(String[] args) {
//        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
//        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{-1,-2,-3,-4,-5,6}));
        System.out.println(new CircularArrayLoop().circularArrayLoop(new int[]{2,-1,1,2,2}));
    }

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0) {
                continue;
            }
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;
            while (true) {
                slow = getNext(nums, forward, slow);
                if(slow == -1){
                    break;
                }
                fast = getNext(nums, forward, fast);
                if(fast == -1){
                    break;
                }
                fast = getNext(nums, forward, fast);
                if(fast == -1){
                    break;
                }
                if(slow == fast) {
                    return true;
                }
            }
            // mark visited path as 0
            int index = i;
            int sign = nums[i];

            while (nums[index] * sign > 0) {
                int next = ((index + nums[index]) % n + n) % n;
                nums[index] = 0;
                index = next;
            }
        }
        return false;
    }

    private int getNext(int[] nums, boolean forward, int i) {
        int n = nums.length;
        if ((nums[i] > 0) != forward) {
            return -1;
        }
        int next = ((i + nums[i]) % n + n) % n;
        if (i == next) {
            return -1;
        }
        return next;
    }
}
