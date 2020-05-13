// https://www.interviewbit.com/problems/symmetric-binary-tree/

public class Solution {
    public int isSymmetric(TreeNode A) {
        if(A==null) return 1;
        return checkSymmetric(A.left,A.right) ? 1 : 0;
    }
    
    private boolean checkSymmetric(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2 == null) return true;
        else if(root1==null || root2==null) return false;
        
        return (root1.val==root2.val) && checkSymmetric(root1.left,root2.right)
            && checkSymmetric(root1.right,root2.left);
    }
}