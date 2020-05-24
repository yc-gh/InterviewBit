// https://www.interviewbit.com/problems/coin-sum-infinite/

public class Solution {
    public int coinchange2(int[] A, int B) {
        int[][] memo = new int[n+1][m+1];
        for(int[] a : memo) Arrays.fill(a,-1);
        // return dp(B, A, memo);
        return dp(B, A);
    }
    
    private static int dp(int n, int[] coins, int m, int[][] memo)
	 {
	     if(n==0) return 1;
	     if(m<1) return 0;
	     if(memo[n][m]!=-1) return memo[n][m];
	     int taken=0, nottaken=0;
	     if(coins[m-1]<=n)
	     {
	         taken = dp(n-coins[m-1], coins, m, memo);
	     }
	     nottaken = dp(n, coins, m-1, memo);
	     return memo[n][m] = taken + nottaken;
	 }
    
    private static int dp(int n, int[] coins)
	 {
	   //  int[][] dp = new int[n+1][m+1];
	   //  for(int i=0; i<=n; i++)
	   //  {
	   //      for(int j=1; j<=m; j++)
	   //      {
	   //          if(i==0) dp[i][j] = 1;
	   //          else
	   //          {
	   //              if(coins[j-1]<=i)
	   //              {
	   //                 dp[i][j] = dp[i-coins[j-1]][j]%1000007; 
	   //              }
    //                 dp[i][j] += dp[i][j-1]%1000007;
	   //          }
	   //      }
	   //  }
	   //  return dp[n][m]%1000007;
	   
        int m = coins.length;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=0; i<m; i++)
        {
            for(int j=coins[i]; j<=n; j++)
            {
                dp[j] += dp[j-coins[i]]%1000007;
            }
        }
        
        return dp[n]%1000007;
	 }
}
