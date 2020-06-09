//https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/

public class Solution {
    public int solve(int[] A) {
        if(A==null || A.length==0) return 0;
        // iterative(A); 
        return recursive(A);
    }
    
    private static int iterative(int[] A)
    {
        int[] heights = new int[A.length];
        int maxDistance = 0;
        for (int i = A.length - 1; i > 0; i--) {
            int parent = A[i];
            int oldParentHeight = 0;
            if(A[i]!=-1) oldParentHeight = heights[parent];
            int newParentHeight = heights[i] + 1; 
            maxDistance = Math.max(maxDistance, newParentHeight + oldParentHeight);
            heights[parent] = Math.max(oldParentHeight, newParentHeight);
        }
        return maxDistance; 
    }
    
    private static int recursive(int[] A)
    {
        int n = A.length;
        List<Integer>[] children = new ArrayList[n];
        for(int i=0; i<n; i++) children[i] = new ArrayList<>();
        int root = -1;
        for(int i=0; i<n; i++)
        {
            if(A[i]==-1) root=i;
            else children[A[i]].add(i);
        }
        int[] max = new int[1];
        height(children, root, max);
        return max[0];
    }
    
    private static int height(List<Integer>[] children, int root, int[] max)
    {
        int maxHeight1=0, maxHeight2=0;
        for(int child : children[root])
        {
            int childHeight = height(children, child, max);
            if(childHeight>maxHeight1)
            {
                maxHeight2 = maxHeight1;
                maxHeight1 = childHeight;
            }
            else if(childHeight>maxHeight2) maxHeight2 = childHeight;
        }
        max[0] = Integer.max(max[0],maxHeight1+maxHeight2);
        return maxHeight1+1;
    }
}
