//https://www.interviewbit.com/problems/paint-house/

public class Solution {
    public int solve(int[][] a) {
        if(a==null || a.length==0) return 0;
        int[][] memo = new int[a.length][4];
        return topDown(a, 0, 0, memo);
    }
    
    private int topDown(int[][] a, int index, int prevColor, int[][] memo)
    {
        if(index>=a.length) return 0;
        if(memo[index][prevColor]>0) return memo[index][prevColor];
        int minCost = Integer.MAX_VALUE;
        for(int c=1; c<=3; c++)
        {
            if(prevColor==0 || c!=prevColor)
            {
                minCost = Integer.min(minCost, a[index][c-1] + topDown(a, index+1, c, memo));
            }
        }
        
        return memo[index][prevColor] = minCost;
    }
}
