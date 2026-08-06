package org.dsa.leetcode.greedy;

public class FractionalKnapSack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        System.out.println(new FractionalKnapSack().fractionalKnapsack(val, wt, 50));
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        double[] valByWt = new double[n];
        double value = 0;
        for (int i = 0; i < n; i++) {
            valByWt[i] = (double)val[i] / (double)wt[i];
        }
        for (int i = 0; i < n && capacity > 0; i++) {
            int maxIndex = getMaxIndex(valByWt);
            if (capacity > wt[maxIndex]) {
                capacity -= wt[maxIndex];
                value += val[maxIndex];
            } else {
                value += ((double)capacity / (double)wt[maxIndex]) * (double)val[maxIndex];
                capacity = 0;
            }
        }
        return value;
    }

    private int getMaxIndex(double[] valByWt) {
        int index = 0;
        for (int i = 0; i < valByWt.length; i++) {
            if (valByWt[i] > valByWt[index]) {
                index = i;
            }
        }
        valByWt[index] = 0;
        return index;
    }
}
