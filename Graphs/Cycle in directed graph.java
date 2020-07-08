//https://www.interviewbit.com/problems/cycle-in-directed-graph/

public class Solution {
    public int solve(int A, int[][] B) {
        List<Integer>[] adjList = new List[A];
        
        for(int[] edge : B)
        {
            int from = edge[0]-1;
            int to = edge[1]-1;
            if(adjList[from] == null) adjList[from] = new ArrayList<>();
            adjList[from].add(to);
        }
        
        boolean[] vis = new boolean[A];
        for(int i=0; i<A; i++)
        {
            if(checkCycle(adjList, i, vis, new boolean[A])) return 1;
        }
        return 0;
    }
    
    private static boolean checkCycle(List<Integer>[] adjList, int curr, boolean[] vis, boolean[] currvis)
    {
        if(currvis[curr]) return true;
        if(vis[curr]) return false;
        
        currvis[curr] = true;
        vis[curr] = true;
        
        if(adjList[curr]!=null)
        {
            for(int adj : adjList[curr])
            {
                if(checkCycle(adjList, adj, vis, currvis)) return true;
            }
        }
        
        currvis[curr] = false;
        return false;
    }
}
