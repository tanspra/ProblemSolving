package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {
  
  public static void main(String[] args) {
    new NQueenProblem().solveNQueens(4).forEach(
        solution -> {
          solution.forEach(row -> {
            System.out.println(row);
          });
          System.out.println();
        }
    );
  }
  
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    char[][] board = new char[n][n];
    nQueens(board, res, 0);
    return res;
  }
  
  private void nQueens(char[][] board, List<List<String>> res, int col) {
    
    //base case
    if (col == board.length) {
      save(board, res);
      return;
    }
    
    //place queen in each column
    for (int row = 0; row < board.length; row++) {
      if (isSafe(board, row, col)) {
        board[row][col] = 'Q';
        nQueens(board, res, col + 1);
        board[row][col] = '.';
      }
    }
  }
  
  private void save(char[][] board, List<List<String>> res) {
    List<String> sol = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      String row = "";
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == 'Q')
          row += 'Q';
        else
          row += '.';
      }
      sol.add(row);
    }
    res.add(sol);
  }
  
  private boolean isSafe(char[][] board, int row, int col) {
    
    //check row
    for (int i = 0; i < board.length; i++) {
      if (board[i][col] == 'Q')
        return false;
    }
    //check col
    for (int i = 0; i < board.length; i++) {
      if (board[row][i] == 'Q')
        return false;
    }
    //check diagonally
    //check upper left
    int r = row, c = col;
    while (r >= 0 && c >= 0) {
      if (board[r][c] == 'Q')
        return false;
      r--;
      c--;
    }
    //check upper right
     r = row;
    c = col;
    while (r >= 0 && c < board.length) {
      if (board[r][c] == 'Q')
        return false;
      r--;
      c++;
    }
    //check lower left
    r = row;
    c = col;
    while (r < board.length && c >= 0) {
      if (board[r][c] == 'Q')
        return false;
      r++;
      c--;
    }
    //check lower right
    r = row;
    c = col;
    while (r < board.length && c < board.length) {
      if (board[r][c] == 'Q')
        return false;
      r++;
      c++;
    }
    
    return true;
  }
}
