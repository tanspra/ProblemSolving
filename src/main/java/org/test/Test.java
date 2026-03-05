package org.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 2, 3, 4, 4};
//        List<Integer> res = removeDuplicate(arr);
//        for (int val : res) {
//            System.out.println(val);
//        }
//        String[] fruits = new String[]{"apple","banana","pear","kiwi"};
//        Stream<String> stream = Stream.of(fruits);
//        stream.forEach((e)->{
//            System.out.println(e +" -> "+ e.length());
//        });
        Stream<Integer> stream = Stream.of(4,2,8,6,10);
        Stream<Integer> sorted = stream.sorted(Collections.reverseOrder());
        List<Integer> collect = sorted.collect(Collectors.toList());
        System.out.println(collect.get(1));
    }

    public static List<Integer> removeDuplicate(int[] arr) {
        Set<Integer> set = new HashSet();
        for (int val : arr) {
            set.add(val);
        }
        List<Integer> res = new ArrayList();
        for (int val : set) {
            res.add(val);
        }
        return res;
    }
}
