package org.dsa.leetcode.p1;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        List<Integer> zeroRow = new ArrayList();
        List<Integer> zeroCol = new ArrayList();
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }
        for(int i = 0; i< zeroRow.size(); i++){
            int row = zeroRow.get(i);
            int col = zeroCol.get(i);
            for(int j = 0; j< matrix[0].length; j++){
                matrix[row][j] = 0;
            }
            for(int j = 0; j< matrix.length; j++){
                matrix[j][col] = 0;
            }
        }

    }
}
