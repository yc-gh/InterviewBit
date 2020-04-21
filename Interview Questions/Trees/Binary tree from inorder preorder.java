// https://www.interviewbit.com/problems/construct-binary-tree-from-inorder-and-preorder/

public class Solution {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int[] preindex = new int[1];
        return buildTreeUtil(A, B, 0, B.size()-1, preindex);
    }
    
    private static TreeNode buildTreeUtil(ArrayList<Integer> A, ArrayList<Integer> B, int l, int r, int[] preindex)
    {
        if(l>r) return null;
        TreeNode root = new TreeNode(A.get(preindex[0]));
        preindex[0]++;
        if(l==r) return root;
        int inIndex = inorderIndex(B, l, r, root.val);
        root.left = buildTreeUtil(A, B, l, inIndex-1, preindex);
        root.right = buildTreeUtil(A, B, inIndex+1, r, preindex);
        return root;
    }
    
    private static int inorderIndex(ArrayList<Integer> B, int l, int r, int key)
    {
        for(int i=l; i<=r; i++)
        {
            if(B.get(i)==key) return i;
        }
    }
}
