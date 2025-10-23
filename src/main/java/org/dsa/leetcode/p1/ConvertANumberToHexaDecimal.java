package org.dsa.leetcode.p1;

public class ConvertANumberToHexaDecimal {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(new ConvertANumberToHexaDecimal().toHex(i));
//        }
        System.out.println(new ConvertANumberToHexaDecimal().toHex(-1));

    }
    public String toHex(int num) {
        char[] HEX_MAP = "0123456789abcdef".toCharArray();
        if(num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        while(num != 0 && sb.length() < 8){
            //get last 4 bit of number
            int n = num & 0XF;
            sb.append(HEX_MAP[n]);
            num = num >>> 4;
        }
        return sb.reverse().toString();
    }
}
