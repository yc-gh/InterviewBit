// https://www.interviewbit.com/problems/least-common-ancestor/

public class Solution {
    public int lca(TreeNode A, int B, int C) {
        int[] found = new int[1];
        int res = lcaUtil(A, B, C, found);
        return (found[0]==2) ? res : -1;
    }
    
    private static int lcaUtil(TreeNode A, int B, int C, int[] found)
    {
        if(A==null) return -1;
        int foundhere = -1;
        if(A.val==B) 
        {
            found[0]++;
            foundhere = A.val;
        }
        if(A.val==C)
        {
            found[0]++;
            foundhere = A.val;
        }
        
        int left = lcaUtil(A.left, B, C, found);
        int right = lcaUtil(A.right, B, C, found);
        if(foundhere != -1) return foundhere;
        if(left != -1 && right!= -1) return A.val;
        return left!=-1 ? left : right;
    }
}
