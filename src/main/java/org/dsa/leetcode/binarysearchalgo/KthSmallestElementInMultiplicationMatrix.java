package org.dsa.leetcode.binarysearchalgo;

public class KthSmallestElementInMultiplicationMatrix {
    public static void main(String[] args) {
        System.out.println(new KthSmallestElementInMultiplicationMatrix().findKthNumber(3,3,5));
    }
    public int findKthNumber(int m, int n, int k) {
      int low = 1, high = m*n;
        while(low <= high){
            int mid = low+(high-low)/2;
            int count = findLessCount(m,n,mid);
            if(count < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private int findLessCount(int m, int n, int mid) {
        int count =0;
        for(int i=1;i<=m;i++){
            count += Math.min(n,mid/i);
        }
        return count;
    }

}
