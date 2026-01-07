package org.test;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        //>> preserves sign bit(1,0)
//        int a = 8;
//         a= a>>2;
//        System.out.println(a);
//        System.out.println(Integer.toBinaryString(a));
        int b = -8;
        b= b>>4;
        System.out.println(b);
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b).length());

//        int c = 8;
//        c = c >>> 2;
//        System.out.println(c);
//        System.out.println(Integer.toBinaryString(c));

        int d = -8;
        d= d >>> 4;
        System.out.println(d);
        System.out.println(Integer.toBinaryString(d));
        System.out.println(Integer.toBinaryString(d).length());
    }
}
