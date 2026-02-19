package org.dsa.leetcode.p5;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 3, 3, 3};
        System.out.println(new FruitIntoBasket().totalFruit(fruits));
    }

    public int totalFruit(int[] fruits) {
        if (fruits.length <= 2) return fruits.length;
        int n = fruits.length;
        int low = 0, high = 1;
        int result = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        //initial filling
        map.put(fruits[low], map.getOrDefault(fruits[low], 0) + 1);
        while (high < n) {
            map.put(fruits[high], map.getOrDefault(fruits[high], 0) + 1);
            if (map.size() >= 3) {
                map.put(fruits[low], map.get(fruits[low]) - 1);
                if (map.get(fruits[low]) == 0) map.remove(fruits[low]);
                low++;
            }
            result = Math.max(result, (high - low + 1));
            high++;
        }
        return result;
    }

    public int totalFruit3(int[] fruits) {
        if (fruits.length <= 2) return fruits.length;
        int n = fruits.length;
        int low = 0, high = 1;
        int result = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        //initial filling
        map.put(fruits[low], map.getOrDefault(fruits[low], 0) + 1);
        while (high < n) {
            map.put(fruits[high], map.getOrDefault(fruits[high], 0) + 1);
            //check distinct
            if (map.size() <= 2 && map.get(fruits[low]) >= 1) {
                result = Math.max(result, (high - low + 1));
            }
            if (map.size() > 2) {
                map.put(fruits[low], map.get(fruits[low]) - 1);
                if (map.get(fruits[low]) == 0) map.remove(fruits[low]);
                low++;
            }
            high++;
        }
        return result;
    }

    public int totalFruit2(int[] fruits) {
        if (fruits.length <= 2) return fruits.length;
        int n = fruits.length;
        int k = 2;
        int low = 0, high = low + k - 1;
        int result = Integer.MIN_VALUE;
        while (high < n) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (fruits[i] == fruits[low] || fruits[i] == fruits[high]) {
                    count++;
                    result = Math.max(result, count);
                } else {
                    count = 0;
                }
            }
            low++;
            high++;
        }
        return result;
    }
}
