package org.test;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //taking input as String
//        String name = sc.next(); //ths will take the first word only
//        String name = sc.nextLine(); //ths will take the first complete line
//        System.out.println(name);

        //taking int as input
           var val = sc.nextInt();//only takes the first word and convert to int
           System.out.println(val);

    }
}
