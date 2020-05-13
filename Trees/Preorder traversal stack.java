// https://www.interviewbit.com/problems/preorder-traversal/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        if(A==null) return new ArrayList<>();
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = A;
        
        while(curr!=null || !stack.isEmpty())
        {
            while(curr!=null)
            {
                res.add(curr.val);
                if(curr.right!=null) stack.push(curr.right);
                curr = curr.left;
            }
            
            if(!stack.isEmpty()) curr=stack.pop();
        }
        return res;
    }
}
