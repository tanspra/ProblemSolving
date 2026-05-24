package org.test;

import java.util.stream.IntStream;

public class ThreadTest {
    volatile static int num = 1;

    public static void main(String[] args) {
        IntStream.range(0, 10)
                .filter(a -> {
                    System.out.println(1);
                    return a%2 == 0;
                })
                .filter(a -> {
                    System.out.println(0);
                    return a > 3;
                })
                .forEach(System.out::println);

    }
}
