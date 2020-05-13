// https://www.interviewbit.com/problems/path-sum/

public class Solution {
    private static boolean found;
    public int hasPathSum(TreeNode A, int B) {
        found = false;
        return checkPathSum(A,B,0) ? 1 : 0;
    }
    
    private static boolean checkPathSum(TreeNode root, int key, int currsum)
    {
        if(found) return true;
        if(root==null) return false;
        if(root.left==null && root.right==null)
        {
            if(currsum+root.val==key)
            {
                found = true;
                return true;
            }
            return false;
        }
        return checkPathSum(root.left, key, currsum+root.val) 
            || checkPathSum(root.right, key, currsum+root.val);
    }
}
