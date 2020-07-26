//https://www.interviewbit.com/problems/chain-of-pairs/

public class Solution {
    public int solve(int[][] a) {
        if(a==null || a.length==0) return 0;
        // int[][] memo = new int[a.length+1][a.length+1];
        // return topDown(a, 1, 0, memo);
        return bottomUp(a);
    }
    
    private int topDown(int[][] a, int curr, int prev, int[][] memo)
    {
        if(curr>a.length) return 0;
        if(memo[curr][prev]>0) return memo[curr][prev];
        int taken=0, nottaken=0;
        if(prev==0 || a[curr-1][0] > a[prev-1][1]) taken = 1 + topDown(a, curr+1, curr, memo);
        nottaken = topDown(a, curr+1, prev, memo);
        
        return memo[curr][prev] = Integer.max(taken,nottaken);
    }
    
    private int bottomUp(int[][] a)
    {
        int[][] dp = new int[a.length+2][a.length+1];
        
        for(int i=a.length; i>=1; i--)
        {
            // for(int j=0; j<=a.length; j++)
            for(int j=a.length; j>=0; j--)
            {
                if(j==0 || a[i-1][0] > a[j-1][1]) dp[i][j] = 1 + dp[i+1][i];
                dp[i][j] = Integer.max(dp[i][j], dp[i+1][j]);
            }
        }
        
        return dp[1][0];
    }
}
