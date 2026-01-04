package org.test;

import java.util.Date;

public class StringFormat {
    public static void main(String[] args) {
        System.out.printf("Float formatting %.2f\n", 2.789f);
        System.out.printf("String formatting %s in the center%n", "Hello");
        System.out.printf("String formatting %S in the center%n", "Hello");
        System.out.printf("Date : %tF today%n", new Date());
        System.out.printf("Date : %tc today%n", new Date());
    }
}
