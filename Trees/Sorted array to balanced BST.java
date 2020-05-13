// https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/

public class Solution {
    public TreeNode sortedArrayToBST(final List<Integer> A) {
        return buildTree(A, 0, A.size()-1);
    }
    
    private static TreeNode buildTree(List<Integer> A, int l, int r)
    {
        if(l>r) return null;
        int mid = l+(r-l)/2;
        TreeNode root = new TreeNode(A.get(mid));
        root.left = buildTree(A,l,mid-1);
        root.right = buildTree(A,mid+1,r);
        return root;
    }
}