// https://www.interviewbit.com/problems/knight-on-chess-board/

public class Solution {
    
    public int knight(int A, int B, int C, int D, int E, int F) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] vis = new boolean[A][B];
        queue.offer(new int[]{C-1,D-1,0});
        int[] rows = {-1,-2,-2,-1,1,2,2,1};
        int[] cols = {-2,-1,1,2,2,1,-1,-2};
        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();
            vis[curr[0]][curr[1]] = true;
            if(curr[0]==E-1 && curr[1]==F-1) return curr[2];
            else
            {
                for(int i=0; i<8; i++)
                {
                    int nextX = curr[0] + rows[i];
                    int nextY = curr[1] + cols[i];
                    if(nextX>=0 && nextX<A && 
                        nextY>=0 && nextY<B && !vis[nextX][nextY])
                    {
                        vis[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY, curr[2]+1});
                    }
                }
            }
        }
        
        return -1;
    }
    
}