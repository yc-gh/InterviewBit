//https://www.interviewbit.com/problems/snake-ladder-problem/

public class Solution {
    public int snakeLadder(int[][] ladders, int[][] snakes) {
        int[] conn = new int[101];
        boolean[] vis = new boolean[101];
        
        for(int[] ladder : ladders) conn[ladder[0]] = ladder[1];
        for(int[] snake : snakes) conn[snake[0]] = snake[1];
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        queue.offer(1);
        
        int steps = 0;
        
        while(!queue.isEmpty())
        {
            
            int size = queue.size();
            
            while(size-->0)
            {
                int curr = queue.poll();
                if(curr==100) return steps;
                vis[curr] = true;
                for(int next=curr+1; next<=curr+6; next++)
                {
                    if(next<=100 && !vis[next]) 
                    {
                        if(conn[next]==0) queue.offer(next);
                        else queue.offer(conn[next]);
                    }
                }
            }
            
            ++steps;
        }
        
        return -1;
    }
}
