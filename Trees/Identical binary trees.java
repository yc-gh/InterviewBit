// https://www.interviewbit.com/problems/identical-binary-trees/

public class Solution {
    public int isSameTree(TreeNode A, TreeNode B) {
        return checkSameTree(A,B) ? 1 : 0;
    }
    
    private boolean checkSameTree(TreeNode A, TreeNode B)
    {
        if(A==null && B==null) return true;
        else if(A==null || B==null) return false;
        
        return (A.val==B.val) && checkSameTree(A.left,B.left) 
            && checkSameTree(A.right,B.right);
    }
}
