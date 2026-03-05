package org.dsa.leetcode.p4;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        System.out.println(new WordSearch().exist(board, "AAB"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        if (word.isEmpty()) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (wordSearchHelper(board, word.substring(1), visited,i,j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean wordSearchHelper(char[][] board, String word, boolean[][] visited, int row, int col) {
        if(word.isEmpty() ){
            return true;
        }
        //move right
        if(isSafe(board,row,col+1,visited) && board[row][col+1] == word.charAt(0)){
            visited[row][col+1] = true;
            if(wordSearchHelper(board,word.substring(1),visited,row,col+1)){
                return true;
            }
            visited[row][col+1] = false;
        }
        //move down
        if(isSafe(board,row+1,col,visited) && board[row+1][col] == word.charAt(0)){
            visited[row+1][col] = true;
            if(wordSearchHelper(board,word.substring(1),visited,row+1,col)){
                return true;
            }
            visited[row+1][col] = false;
        }
        //move left
        if(isSafe(board,row,col-1,visited) && board[row][col-1] == word.charAt(0)){
            visited[row][col-1] = true;
            if(wordSearchHelper(board,word.substring(1),visited,row,col-1)){
                return true;
            }
            visited[row][col-1] = false;
        }
        //move up
        if(isSafe(board,row-1,col,visited) && board[row-1][col] == word.charAt(0)){
            visited[row-1][col] = true;
            if(wordSearchHelper(board,word.substring(1),visited,row-1,col)){
                return true;
            }
            visited[row-1][col] = false;
        }
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, boolean[][] visited) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col];
    }
}
