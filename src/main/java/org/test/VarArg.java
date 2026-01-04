package org.test;

public class VarArg {
static int sum(int... args){
    int sum = 0;
    for (int a : args){
        sum = sum+a;
    }
    return sum;
}
    static int sumWithFixedVal(int ab, int b, int... args){
        int sum = ab+b;
        for (int a : args){
            sum = sum+a;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("Sum is "+sum(1,2,3,4));
        System.out.println("Sum is "+sumWithFixedVal(12,23));
    }
}
