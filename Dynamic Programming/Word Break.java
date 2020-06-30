//https://www.interviewbit.com/problems/word-break/

public class Solution {
    public int wordBreak(String s, ArrayList<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return dp(s, 0, wordSet, new Boolean[s.length()+1]) ? 1 : 0;
    }
    
    public static boolean dp(String s, int start, Set<String> wordSet, Boolean[] dp)
    {
        if(start>=s.length()) return true;
        
        if(dp[start]!=null) return dp[start];

        for(int i=start+1; i<=s.length(); i++)
        {
            String temp = s.substring(start,i);
            
            if(wordSet.contains(temp) && dp(s, i, wordSet, dp)) 
            {
                return dp[start] = true;
            }
        }
        
        return dp[start] = false;
    }
}
