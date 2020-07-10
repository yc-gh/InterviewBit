//https://www.interviewbit.com/problems/distinct-subsequences/

public class Solution {
    public int numDistinct(String A, String B) {
        // int[][] memo = new int[A.length()][B.length()];
        // for(int[] a : memo) Arrays.fill(a, -1);
        // return topDown(A.toCharArray(), B.toCharArray(), 0, 0, memo);
        
        return bottomUp(A.toCharArray(), B.toCharArray());
    }
    
    private static int bottomUp(char[] s, char[] t)
    {
        int n=s.length, m=t.length;
        
        int[] dp = new int[m+1];
        dp[m] = 1;
        
        for(int i=n-1; i>=0; i--)
        {
            int pre = dp[m];
            for(int j=m-1; j>=0; j--)
            {
                // int saved = dp[j];
                // dp[j] = 0;
                // if(s[i]==t[j])
                // {
                //     dp[j] = pre;
                // }
                // dp[j] += saved;
                // pre = saved;
                
                int saved = dp[j];
                if(s[i]==t[j]) dp[j] += pre;
                pre = saved;
            }
        }
        return dp[0];
    }
    
    private static int topDown(char[] s, char[] t, int i, int j, int[][] memo)
    {
        if(i>=s.length && j<t.length) return 0;
        if(j==t.length) return 1;
        if(memo[i][j] != -1) return memo[i][j];
        int taken=0, nottaken=0;
        
        if(s[i]==t[j])
        {
            taken = topDown(s,t,i+1,j+1,memo);
        }
        
        nottaken = topDown(s,t,i+1,j,memo);
        
        return memo[i][j] = taken+nottaken;
    }
}
