// https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/

public class Solution {
    public int solve(int numCourses, int[] B, int[] C) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        boolean[] vis = new boolean[numCourses+1];
        boolean[] currvis = new boolean[numCourses+1];
        
        for(int i=0; i<B.length; i++)
        {
            if(!map.containsKey(B[i]))
            {
                map.put(B[i], new ArrayList());
            }
            map.get(B[i]).add(C[i]);
        }
        
        
        for(int course=1; course<=numCourses; course++)
        {
            if(!dfs(map, vis, currvis, course)) return 0;
        }
        
        return 1;
    }
    
    private boolean dfs(Map<Integer,List<Integer>> map, 
                        boolean[] vis, boolean[] currvis, int curr)
    {
        if(currvis[curr]) return false;
        if(vis[curr]) return true;
        if(!map.containsKey(curr)) return true;
        vis[curr] = true;
        currvis[curr] = true;
        for(int adj : map.get(curr))
        {
            if(!dfs(map, vis, currvis, adj)) return false;
        }
        currvis[curr] = false;
        return true;
    }
}
