package org.dsa.pattern;

import java.util.Scanner;

public class TrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row no : ");
        int row = sc.nextInt();
//        triangle(row);
//        triangle1(row);
        triangle2(row);
    }

    /*// N = 5
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15*/
    static void triangle2(int row){
        int val =1;
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(val++);
            }
            System.out.println();
        }
    }

/*// N = 5
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5*/

    static void triangle1(int row){
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(j+1+" ");
            }
            System.out.println();
        }
    }
    /*// N = 5
1
2 2
3 3 3
4 4 4 4
5 5 5 5 5
*/
    static void triangle(int row) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
