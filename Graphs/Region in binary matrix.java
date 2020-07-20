//https://www.interviewbit.com/problems/region-in-binarymatrix/

public class Solution {
    public int solve(int[][] a) {
        if(a==null || a.length==0) return 0;
        int m = a.length, n = a[0].length;
        
        boolean[][] vis = new boolean[m][n];
        
        int maxCount = 0;
        
        int[][] adj = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(a[i][j]==1 && !vis[i][j]) 
                {
                    maxCount = Integer.max(maxCount, dfs(a,i,j,vis,adj));
                }
            }
        }
        
        return maxCount;
    }
    
    private int dfs(int[][] a, int i, int j, boolean[][] vis, int[][] adj)
    {
        vis[i][j] = true;
        
        int count = 1;
        
        for(int k=0; k<8; k++)
        {
            int nextI = i+adj[k][0], nextJ = j+adj[k][1];
            if(canGoTo(a,nextI,nextJ,vis)) count += dfs(a,nextI,nextJ,vis,adj);
        }
        
        return count;
    }
    
    private boolean canGoTo(int[][] a, int i, int j, boolean[][] vis)
    {
        return (i>0 && i<a.length && j>0 && j<a[0].length && a[i][j]==1 && !vis[i][j]);
    }
}
