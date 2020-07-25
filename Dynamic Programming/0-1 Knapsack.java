//https://www.interviewbit.com/problems/0-1-knapsack/

public class Solution {
    public int solve(int[] v, int[] w, int c) {
        if(v==null || w==null || v.length==0 || w.length==0) return 0;
        int[][] memo = new int[v.length][c+1];
        return topDown(v, w, 0, c, memo);
    }
    
    private int topDown(int[] v, int[] w, int i, int c, int[][] memo)
    {
        if(c<=0 || i>=v.length) return 0;
        if(memo[i][c]>0) return memo[i][c];
        
        int taken=0, nottaken=0;
        
        if(w[i]<=c) taken = v[i] + topDown(v,w,i+1,c-w[i],memo);
        nottaken = topDown(v,w,i+1,c,memo);
        
        return memo[i][c] = Integer.max(taken,nottaken);
    }
}
