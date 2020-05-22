// https://www.interviewbit.com/problems/longest-increasing-subsequence/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] a) {
        int n = a.length;
        int[][] memo = new int[n + 1][n + 1];
        for (int[] arr : memo)
            Arrays.fill(arr, -1);
        return lisMemo(a, n, 0, -1, memo);
    }

    private static int lisMemo(int[] a, int n, int curr, int prev, int[][] memo) {
        if (curr == n)
            return 0;
        if (memo[curr + 1][prev + 1] != -1)
            return memo[curr + 1][prev + 1];
        int taken = 0, notTaken = 0;
        if (prev == -1 || a[curr] > a[prev])
            taken = 1 + lisMemo(a, n, curr + 1, curr, memo);
        notTaken = lisMemo(a, n, curr + 1, prev, memo);
        int lisFromHere = Integer.max(taken, notTaken);
        return memo[curr + 1][prev + 1] = lisFromHere;
    }
}
