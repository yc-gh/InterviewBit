// https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/

// Recursion fast
public class Solution {
    public TreeNode flatten(TreeNode root) {
        if(root==null) return null;
        TreeNode right = root.right;
        root.right = flatten(root.left);
        root.left = null;
        TreeNode curr = root;
        while(curr.right!=null) curr=curr.right;
        curr.right = flatten(right);
        return root;
    }
}

// Preorder without stack - extra space
public class Solution {
    
    TreeNode root = new TreeNode(0);
    TreeNode curr = root;
    
    public TreeNode flatten(TreeNode a) {
        preorder(a);
        return root.right;
    }
    
    private void preorder(TreeNode a)
    {
        if(a==null) return;
        curr.right = new TreeNode(a.val);
        curr = curr.right;
        preorder(a.left);
        preorder(a.right);
    }
}
