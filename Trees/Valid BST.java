// https://www.interviewbit.com/problems/valid-binary-search-tree/

public class Solution {
    public int isValidBST(TreeNode A) {
        return checkBST(A, null, null) ? 1 : 0;
    }
    
    private boolean checkBST(TreeNode curr, Integer low, Integer high) {
        if (curr == null)
            return true;
        return ((low == null || curr.val > low) && (high == null || curr.val < high)
                && checkBST(curr.left, low, curr.val) && checkBST(curr.right, curr.val, high));
    }
}