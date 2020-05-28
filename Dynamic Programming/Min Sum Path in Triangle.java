//https://www.interviewbit.com/problems/min-sum-path-in-triangle/

public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> t) {
	    int r = t.size();
        int c = t.get(r-1).size();
        int[] dp = new int[r+1];
        for(int i=r-1; i>=0; i--)
        {
            for(int j=0; j<c; j++)
            {
                if(j<t.get(i).size())
                {
                    dp[j] = t.get(i).get(j) + Integer.min(dp[j],dp[j+1]);
                }
            }
        }
        return dp[0];
	}
}
