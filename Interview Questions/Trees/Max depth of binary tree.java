// https://www.interviewbit.com/problems/max-depth-of-binary-tree/

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        return Integer.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}