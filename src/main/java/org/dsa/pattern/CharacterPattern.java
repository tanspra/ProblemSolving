package org.dsa.pattern;

import java.util.Scanner;

public class CharacterPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row no : ");
        int row = sc.nextInt();
//        characterPattern(row);
        characterPattern1(row);
    }

    /*// N = 4
ABCD
BCDE
CDEF
DEFG
*/
    static void characterPattern1(int row){
        char ch = 'A';
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print((char)(ch+j));
            }
            ch++;
            System.out.println();
        }
    }
    /*// N = 4
ABCD
ABCD
ABCD
ABCD
     */

    static void characterPattern(int row){
        for (int i = 0; i < row; i++) {
            char ch ='A';
            for (int j = 0; j < row; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
}
