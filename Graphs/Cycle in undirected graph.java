//https://www.interviewbit.com/problems/cycle-in-undirected-graph/

//Union find
public class Solution {
    
    static int[] parent;
    
    public int solve(int V, int[][] g) {
        parent = new int[V+1];
        
        for(int i=1; i<=V; i++) parent[i] = i;
        
        for(int i=0; i<g.length; i++)
        {
            if(findSet(g[i][0]) != findSet(g[i][1])) 
                union(g[i][0], g[i][1]);
            else return 1;
        }
        return 0;
    }
    
    private static int findSet(int x)
    {
        if(parent[x]==x) return x;
        else return parent[x] = findSet(parent[x]);
    }
    
    private static void union(int x, int y)
    {
        if(findSet(x) != findSet(y))
        {
            parent[findSet(y)] = findSet(x);
        }
    }
}


//DFS

public class Solution {
    public int solve(int V, ArrayList<ArrayList<Integer>> g) {
        List<Integer>[] graph = new ArrayList[V+1];
        for(int i=0; i<=V; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<g.size(); i++)
        {
            graph[g.get(i).get(0)].add(g.get(i).get(1));
            graph[g.get(i).get(1)].add(g.get(i).get(0));
        }
        boolean[] vis = new boolean[V+1];
        for(int i=1; i<=V; i++)
        {
            if(isCyclicUtil(i, i, graph, vis)) return 1;
        }
        return 0;
    }
    
    private static boolean isCyclicUtil(int curr, int parent, 
                                        List<Integer>[] g, boolean[] vis) 
    {
        if(vis[curr]) return false;
        vis[curr] = true;
        
        for(int adj : g[curr])
        {
            if(parent!=adj && vis[adj] && adj!=parent)
            {
                return true;
            }
            else 
            {
                if(isCyclicUtil(adj, curr, g, vis)) return true;
            }
        }

        
        return false;
    }
}
