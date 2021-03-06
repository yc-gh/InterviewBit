//https://www.interviewbit.com/problems/longest-common-subsequence/

public class Solution {
    public int solve(String text1, String text2) {
        return dp(text1.toCharArray(), text2.toCharArray());
    }
    
    private static int dp(char[] text1, char[] text2)
    {
        int n = text1.length;
        int m = text2.length;
        
        // int[][] dp = new int[n+1][m+1];
        
        // int[][] dp = new int[2][m+1];
        
        int[] dp = new int[m+1];
        
        // int flag = 0;
        
        
        for(int i=n-1; i>=0; i--)
        {
            int pre = 0;
            for(int j=m-1; j>=0; j--)
            {
                // if(text1[i]==text2[j]) dp[i][j] = 1 + dp[i+1][j+1];
                // if(text1[i]==text2[j]) dp[flag][j] = 1 + dp[flag^1][j+1];
                
                int saved = dp[j];
                if(text1[i]==text2[j]) dp[j] = 1 + pre;
                else
                {
                    // dp[i][j] = Integer.max(dp[i+1][j], dp[i][j+1]);
                    // dp[flag][j] = Integer.max(dp[flag^1][j], dp[flag][j+1]); 
                    
                    dp[j] = Integer.max(dp[j], dp[j+1]);
                }
                pre = saved;
            }
            
            // flag ^= 1;
        }
        
        // return dp[flag^1][0];
        
        return dp[0];
    }
}
