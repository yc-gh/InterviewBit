//https://www.interviewbit.com/problems/maximum-path-in-triangle/

public class Solution {
    public int solve(int[][] a) {
        if(a==null || a.length==0) return 0;
        // int[][] memo = new int[a.length][a.length];
        // return topDown(a,0,0,memo);
        return bottomUp(a);
    }
    
    private int topDown(int[][] a, int i, int j, int[][] memo)
    {
        if(i>=a.length || j>=a[0].length) return 0;
        if(memo[i][j]>0) return memo[i][j];
        return memo[i][j] = a[i][j] + Integer.max(topDown(a,i+1,j,memo), topDown(a,i+1,j+1,memo));
    }
    
    private int bottomUp(int[][] a)
    {
        // int[][] dp = new int[2][a[0].length+1];
        // int flag = 1;
        // for(int i=a.length-1; i>=0; i--)
        // {
        //     for(int j=a[0].length-1; j>=0; j--)
        //     {
        //         dp[flag][j] = a[i][j] + Integer.max(dp[flag^1][j], dp[flag^1][j+1]);
        //     }
        //     flag ^= 1;
        // }
        
        // return dp[flag^1][0];
        
        int[] dp = new int[a[0].length+1];
        
        int pre = 0;
        
        for(int i=a.length-1; i>=0; i--)
        {
            for(int j=a[0].length-1; j>=0; j--)
            {
                int temp = dp[j];
                dp[j] = a[i][j] + Integer.max(dp[j], pre);
                pre = temp;
            }
        }
        
        return dp[0];
    }
}
