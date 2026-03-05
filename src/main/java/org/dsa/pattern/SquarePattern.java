package org.dsa.pattern;

import java.util.Scanner;


public class SquarePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row no : ");
        int row = sc.nextInt();
//        square(row);
//        square1(row);
//        square2(row);
        square3(row);
    }
/*// N = 5
1 2 3 4 5
2 3 4 5 6
3 4 5 6 7
4 5 6 7 8
5 6 7 8 9
*/
    static void square3(int row){
        for (int i = 1; i <= row; i++) {
            for (int k = i; k < i+row; k++) {
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }
    /*
    * // N = 5
5 4 3 2 1
5 4 3 2 1
5 4 3 2 1
5 4 3 2 1
5 4 3 2 1
* */
    static void square2(int row){
        for (int i = 0; i < row; i++) {
              int j = row;
              while(j>0){
                  System.out.print(j+" ");
                  j--;
              }
            System.out.println();
        }
    }
    /*
    // N = 5
    1 2 3 4 5
    1 2 3 4 5
    1 2 3 4 5
    1 2 3 4 5
    1 2 3 4 5
    * */
    static void square1(int row) {
        int i = 1;
        while (i <= row) {
            int j = 1;
            while (j <= row) {
                System.out.print(j + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    /* Square Pattern
// N = 5
1 1 1 1 1
2 2 2 2 2
3 3 3 3 3
4 4 4 4 4
5 5 5 5 5
* */
    static void square(int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        }
    }
}
