//interviewbit.com/problems/subset-sum-problem/

public class Solution {
    
    // public int solve(int[] A, int B) {
    //     boolean dp[] = new boolean[B + 1];
        
    //     dp[0] = true;
        
    //     for (int i = 0; i < A.length; i++) {
    //         for (int j = dp.length - 1; j >= 0; j--) {
    //             if (j >= A[i])
    //                 dp[j] |= dp[j - A[i]];
    //         }
    //     }
        
    //     return dp[B] ? 1 : 0;
    // }
    
    
    public int solve(int[] a, int b) {
        if(a==null || a.length==0) return 0;
        // Boolean[][] memo = new Boolean[a.length][b+1];
        // for(Boolean[] arr : memo) Arrays.fill(arr,null);
        // return topDown(a, b, a.length-1, memo) ? 1 : 0;
        return bottomUp(a, b);
    }
    
    private Boolean topDown(int[] a, int sum, int i, Boolean[][] memo)
    {
        if(sum==0) return true;
        if(i<0 || sum<0) return false;
        if(memo[i][sum]!=null) return memo[i][sum];
        if(a[i]>sum) return memo[i][sum] = topDown(a,sum,i-1,memo);
        return memo[i][sum] = topDown(a,sum-a[i],i-1,memo) || topDown(a,sum,i-1,memo);
    }
    
    private int bottomUp(int[] a, int sum)
    {
        boolean[][] dp = new boolean[sum+1][a.length+1];
        
        
        for(int i=0; i<=a.length; i++) dp[0][i] = true;
        for(int i=1; i<=sum; i++) dp[i][0] = false;
        
        for(int i=1; i<=sum; i++)
        {
            for(int j=1; j<=a.length; j++)
            {
                dp[i][j] = dp[i][j-1];
                if(i>=a[j-1]) dp[i][j] = dp[i][j] || dp[i-a[j-1]][j-1];
            }
        }
        
        return dp[sum][a.length] ? 1 : 0;
    }
}
