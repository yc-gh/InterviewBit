//https://www.interviewbit.com/problems/longest-arithmetic-progression/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A) {
        int n = A.length;
        if(n<2) return n;
        int res = 2;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < n; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}
