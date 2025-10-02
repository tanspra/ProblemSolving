package org.dsa.leetcode.p4;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(new ValidSudoku().isValidSudokuShort(new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }

    public boolean isValidSudokuShort(char[][] board) {
        Set seen = new HashSet();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i / 3 + b + j / 3))
                        return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col] != '.'){
                    if(!isValidPosition(board[row][col],row,col,board)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidPosition(char checkDigit, int row, int col, char[][] board) {
        //check for row
        int count = 0;
        for(int i = 0; i < 9; i++){
            if(board[row][i] == checkDigit){
                count++;
            }
        }
        if(count >1){
            return false;
        }
        //check for column
        count =0;
        for(int i = 0; i < 9; i++){
            if(board[i][col] == checkDigit){
                count++;
            }
        }
        if(count >1){
            return false;
        }
        //check in the box
        count=0;
        int startRow = 3*(row/3);
        int endRow = startRow +2;
        int startCol = 3*(col/3);
        int endCol = startCol +2;
        for(int i = startRow; i <= endRow; i++){
            for(int j = startCol; j <= endCol; j++){
                if(board[i][j] == checkDigit){
                    count++;
                }
            }
        }
        if(count >1){
            return false;
        }
        return true;
    }
}
