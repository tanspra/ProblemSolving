package org.leetcode;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }

    public String countAndSay(int n) {
        String rle = "1";
        if (n == 1)
            return rle;
        for (int i = 1; i < n; i++) {
            rle = runLengthEncoding(rle);
        }
        return rle;
    }

    public String runLengthEncoding(String n) {
        StringBuffer res = new StringBuffer();
        int count = 1;
        for (int i = 1; i < n.length(); i++) {
            if (n.charAt(i) == n.charAt(i - 1)) {
                count++;
            } else {
                //add previous no with count
                res.append(count);
                res.append(n.charAt(i - 1));
                count = 1;
            }
        }
        //add last element
        res.append(count);
        res.append(n.charAt(n.length() - 1));
        return res.toString();
    }
}
