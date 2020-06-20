//https://www.interviewbit.com/problems/balanced-binary-tree/

public class Solution {
    public int isBalanced(TreeNode root) {
        return height(root)!=-1 ? 1 : 0;
    }
    
    private static int height(TreeNode root)
    {
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(left==-1 || right==-1) return -1;
        else if(Math.abs(left-right)>1) return -1;
        else return 1 + Integer.max(left,right);
    }
}
