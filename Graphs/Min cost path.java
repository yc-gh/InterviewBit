//https://www.interviewbit.com/problems/min-cost-path/

public class Solution {
    public int solve(int r, int c, String[] s) {
        boolean[][] vis = new boolean[r][c];
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,0});
        
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], cost = curr[2];
            
            if(i==r-1 && j==c-1) return cost;
            
            vis[i][j] = true;
            
            if(i>=1 && !vis[i-1][j]) 
            {
                if(s[i].charAt(j)=='U') queue.offerFirst(new int[]{i-1,j,cost});
                else queue.offerLast(new int[]{i-1,j,cost+1});
            }
            
            if(j<c-1 && !vis[i][j+1]) 
            {
                if(s[i].charAt(j)=='R') queue.offerFirst(new int[]{i,j+1,cost});
                else queue.offerLast(new int[]{i,j+1,cost+1});
            }
            
            if(j>=1 && !vis[i][j-1])
            {
                if(s[i].charAt(j)=='L') queue.offerFirst(new int[]{i,j-1,cost});
                else queue.offerLast(new int[]{i,j-1,cost+1});
            }
            
            if(i<r-1 && !vis[i+1][j])
            {
                if(s[i].charAt(j)=='D') queue.offerFirst(new int[]{i+1,j,cost});
                else queue.offerLast(new int[]{i+1,j,cost+1});
            }
        }
        
        return -1;
    }
}
