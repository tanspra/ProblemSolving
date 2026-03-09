package org.dsa.leetcode.p6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static void main(String[] args) {
//        System.out.println(new TaskScheduler().leastInterval("AAABBB".toCharArray(), 2));
//        System.out.println(new TaskScheduler().leastInterval("AA".toCharArray(), 2));
        System.out.println(new TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B','C','D','E','F','G','H','I','J','K'}, 7));
    }

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> register = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) return b.c - a.c;
            return b.count - a.count;
        });
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : map.keySet()) {
            pq.offer(new Pair(map.get(ch), ch));
            register.put(ch, 0);
        }
        int seat = 0;
        while (!pq.isEmpty()) {
            List<Pair> temp = new ArrayList<>();
           while(!pq.isEmpty()){
               Pair p = pq.poll();
               if (seat >= register.get(p.c)) {
                   p.count -= 1;
                   if (p.count > 0) {
                       pq.offer(p);
                   }
                   register.put(p.c, seat + n + 1);
                   break;
               }else{
                   temp.add(p);
               }
           }
           pq.addAll(temp);
           seat++;
        }
        return seat;
    }

    private class Pair {
        int count;
        char c;

        Pair(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
}
