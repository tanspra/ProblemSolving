package org.dsa.pattern;

import java.util.Scanner;

public class PractisePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row no : ");
        int row = sc.nextInt();
//        pattern(row);
//        pattern1(row);
//        pattern2(row);
//        pattern3(row);
//        pattern4(row);
//        pattern5(row);
//        pattern6(row);
//        pattern7(row);
//        pattern8(row);
//        pattern9(row);
//        pattern10(row);
        pattern11(row);
    }
    /*
      1     1
       2   2
        3 3
         4
        3 3
       2   2
      1     1
     */
    static void pattern11(int n){
        int row = 1;
        while(row < 2*n){
            int num = row > n ? 2*n-row : row;
            int col = 2*n - num;
            int ls = num-1;
            for (int i = 0; i < ls; i++) {
                System.out.print(" ");
            }
            System.out.print(num);
            int cs = (row == n) ? 0 : (col - ls -2);
            for (int i = 0; i < cs; i++) {
                System.out.print(" ");
            }
            if(row != n)
                System.out.print(num);
            row++;
            System.out.println();
        }
    }

    /*
       1
      121
     12321
    1234321
     12321
      121
       1
     */
    static void pattern10(int n){
        int row = 1;
        while(row < 2*n){
            int spaces = 1;
            while(spaces <= Math.abs((n-row))){
                System.out.print(" ");
                spaces++;
            }

            int val = row;
            if(val> n){
                val = 2*n -row;
            }
            int num = 1;
            while(num <= val){
                System.out.print(num);
                num++;
            }
            num = val-1;
            while(num >= 1){
                System.out.print(num);
                num--;
            }
            row++;
            System.out.println();
        }
    }
    /*
        *
       ***
      *****
     *******
     */
    static void pattern9(int n){
        int row = 1;
        while(row <= n){
            int spaces = 1;
            while(spaces <= n-row){
                System.out.print(" ");
                spaces++;
            }
            int count = 1;
            while(count <= 2*row-1){
                System.out.print("*");
                count++;
            }
            row++;
            System.out.println();
        }
    }
    /*
    // N = 4
           1
          121
         12321
        1234321
     */
    static void pattern8(int n){
        int row = 1;
        while(row <= n){
           int spaces =1;
           while(spaces <= (n-row)){
               System.out.print(" ");
               spaces++;
           }
           int num = 1;
           while(num <= row){
               System.out.print(num);
               num++;
           }
           num = row-1;
           while(num >= 1){
               System.out.print(num);
               num--;
           }
            System.out.println();
            row++;
        }
    }
    // N = 3
//              *
//            * *
//          * * *
static void pattern7(int n){
        int row =1;
        while(row <= n){
            int col = 1;
            while(col <= n){
                if(col<=(n-row)){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
                col++;
            }
            System.out.println();
            row++;
        }
}
//     N = 3
//        * * *
//        * *
//        *

    static void pattern6(int row){
        int r=1;
        while(r<=row){
            int c = row;
            while(c>=r){
                System.out.print("*");
                c--;
            }
            System.out.println();
            r++;
        }
    }
    /*
    A
    BB
    CCC
    DDDD
    */
    static void pattern5(int row){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print((char)('A'+i));
            }
            System.out.println();
        }
    }
    /*
    1
    11
    202
    3003
   */
    static void pattern4(int row) {
        for (int i = 1; i <= row; i++) {
            if(i==1)
                System.out.print(1);
            else{
                System.out.print(i-1);
                for (int j = 1; j <=i-2; j++) {
                    System.out.print(0);
                }
                System.out.print(i-1);
            }
            System.out.println();
        }
    }

    /*
    4555
    3455
    2345
    1234
   */
    static void pattern3(int row) {
        int n = row;
        int rowMinus = row;
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(n++);
            }
            for (int j = i; j < row ; j++) {
                System.out.print(row+1);
            }
            rowMinus--;
            n = rowMinus;
            System.out.println();
        }
    }

    /*
    ABCD
    ABC
    AB
    A
    */
    static void pattern2(int row) {
        for (int i = row; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print((char) ('A' + j));
            }
            System.out.println();
        }
    }

    /*
    12344321
    123**321
    12****21
    1******1
    */
    static void pattern1(int row) {
        for (int i = row; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 0; j < 2 * (row - i); j++) {
                System.out.print("*");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /*
    A
    AB
    ABC
    ABCD
    */
    static void pattern(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((char) ('A' + j));
            }
            System.out.println();
        }
    }
}
