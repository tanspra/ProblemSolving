package org.leetcode;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public void solveSudoku(char[][] board) {
        sudokuSolution(board);
    }


    public boolean sudokuSolution(char[][] board) {

        // traverse the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '.') {
                    for (char i = '1'; i <= '9'; i++) {
                        if (isValidPosition(i, row, col, board)) {
                            board[row][col] = i;
                            if (sudokuSolution(board)){
                                return true;
                            }
                            board[row][col] = '.';
                        }

                    }
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidPosition(char checkDigit, int row, int col, char[][] board) {
        //check for row
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == checkDigit) {
                count++;
            }
        }
        if (count > 0) {
            return false;
        }
        //check for column
        count = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == checkDigit) {
                count++;
            }
        }
        if (count > 0) {
            return false;
        }
        //check in the box
        count = 0;
        int startRow = 3 * (row / 3);
        int endRow = startRow + 2;
        int startCol = 3 * (col / 3);
        int endCol = startCol + 2;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (board[i][j] == checkDigit) {
                    count++;
                }
            }
        }
        if (count > 0) {
            return false;
        }
        return true;
    }
}
