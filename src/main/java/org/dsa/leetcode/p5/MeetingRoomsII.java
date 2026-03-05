package org.dsa.leetcode.p5;

import java.util.Arrays;

public class MeetingRoomsII {
    public static void main(String[] args) {
        System.out.println(new MeetingRoomsII().minMeetingRooms(new int[]{0,30}, new int[]{1,30}));
    }
    public int minMeetingRooms(int[] start, int[] end) {
        int room = 0;
        int ans = 0;
        int i = 0, j= 0;
        Arrays.sort(start);
        Arrays.sort(end);
        while(i < start.length && j < end.length){
            if(start[i] < end[j]){
                room++;
                i++;
                ans = Math.max(ans, room);
            }else{
                j++;
                room--;
            }
        }
        return ans;
    }
}
