// https://www.interviewbit.com/problems/gas-station/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int canCompleteCircuit(final int[] gas, final int[] cost) {
        int n  = gas.length;
        int totalGasUsed = 0; 
        int start = 0;
        int currGas = 0;
        for (int i = 0; i < n; i++) {
            totalGasUsed += gas[i] - cost[i];
            currGas += gas[i] - cost[i];
            if(currGas < 0) {
                currGas = 0;
                start = i+1;
            }
        }
        return totalGasUsed < 0 ? -1 : start%n;
    }
}
