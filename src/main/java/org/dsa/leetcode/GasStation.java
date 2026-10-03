package org.dsa.leetcode;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(sum(gas) < sum(cost))
            return -1;
        int total = 0, tank =0,start = -1, diff = 0;
        for(int i = 0 ; i < gas.length; i++ ){
            diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if(tank < 0){
                start = i+1;
                tank = 0;
            }
        }
        return total>=0 ? start : -1;
    }
    private int sum(int[] arr){
        int sum = 0;
        for(int num:arr)
            sum+=num;
        return sum;
    }

    /* NAIVE APPROACH,ITS GIVES Time limit reached
    *  public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] gas1 = new int[2*n];
        int[] cost1 = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            gas1[i] = gas[i%n];
            cost1[i] = cost[i%n];
        }
        int start = -1;
        for (int i = 0; i <n; i++) {
            if(gas1[i] >= cost1[i]){
                if(canComplete(i, gas1, cost1)) {
                    start = i;
                    break;
                }
            }
        }
        return start;
    }

    private boolean canComplete(int i, int[] gas1, int[] cost1) {
        int totalGas = 0;
        for (int j = i; j < i+gas1.length/2 ; j++) {
            totalGas += gas1[j];
            totalGas -= cost1[j];
            if(totalGas < 0)
                return false;
        }
        return true;
    }
    * */
}
