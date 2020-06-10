//https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/

public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        pathSum(root, max);
        return max[0];
    }
    
    private static int pathSum(TreeNode root, int[] max)
    {
        if(root==null) return 0;
        int left = Integer.max(0,pathSum(root.left, max));
        int right = Integer.max(0,pathSum(root.right, max));
        int through = left + right + root.val;
        max[0] = Integer.max(max[0], through);
        return root.val + Integer.max(left,right);
    }
}
