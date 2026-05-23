package org.dsa.leetcode.graph;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        System.out.println(Arrays.deepToString(Arrays.stream(board).toArray()));
        new SurroundedRegions().solve(board);
        System.out.println(Arrays.deepToString(Arrays.stream(board).toArray()));
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O')
                helper(board, 0, i);
            if (board[rows - 1][i] == 'O')
                helper(board, rows - 1, i);
        }
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O')
                helper(board, i, 0);
            if (board[i][cols - 1] == 'O')
                helper(board, i, cols - 1);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'P')
                    board[i][j] = 'O';
            }
        }
    }

    private void helper(char[][] board, int row, int col) {
        board[row][col] = 'P';
        //move down
        if(isValid(board, row+1, col) && board[row+1][col] == 'O')
            helper(board, row + 1, col);
        //move up
        if(isValid(board, row-1, col) && board[row-1][col] == 'O')
            helper(board, row-1, col);
        //move left
        if(isValid(board, row, col-1) && board[row][col-1] == 'O')
            helper(board, row, col-1);
        //move right
        if(isValid(board, row, col+1) && board[row][col+1] == 'O')
            helper(board, row, col+1);
    }

    private boolean isValid(char[][] board, int row, int col) {
        return  row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }
}
