//https://www.interviewbit.com/problems/remove-half-nodes/

public class Solution {
    public TreeNode solve(TreeNode root) {
        // if(root==null) return root;
        // root.left = solve(root.left);
        // root.right = solve(root.right);
        // if(root.left==null && root.right!=null) return root.right;
        // else if(root.left!=null && root.right==null) return root.left;
        // return root;
        
        if(root.left==null && root.right==null) return root;
        if(root.left==null) return solve(root.right);
        else if(root.right==null) return solve(root.left);
        root.left = solve(root.left);
        root.right = solve(root.right);
        return root;
    }
}
