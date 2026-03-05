package org.dsa.leetcode.p5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIPAddress {
    public static void main(String[] args) {
        List<String> strings = new RestoreIPAddress().restoreIpAddresses("25525511135");
        System.out.println(Arrays.toString(strings.toArray()));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddressHelper(s, "", 1, result);
        return result;
    }

    private void restoreIpAddressHelper(String s, String p, int count, List<String> res) {
        if (s.isEmpty() && count == 5) {
            res.add(p);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String part = s.substring(0, i);
            if (isValid(part)) {
                if (count > 4 && !s.isEmpty()) {
                    return;
                }
                p = (p.isEmpty()) ? part : p + "." + part;
                restoreIpAddressHelper(s.substring(i), p, count + 1, res);
                String[] split = p.split("\\.");
                List<String> collect = Arrays.stream(split).collect(Collectors.toList());
                collect.remove(split.length-1);
                p = String.join(".", collect);
            } else {
                return;
            }
        }
    }

    private boolean isValid(String num) {
        if (num.length() > 1 && num.charAt(0) == '0') return false;
        return Integer.parseInt(num) >= 0 && Integer.parseInt(num) <= 255;
    }
}
