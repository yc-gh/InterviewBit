// https://www.interviewbit.com/problems/kth-smallest-element-in-tree/

public class Solution {
    public int kthsmallest(TreeNode A, int B) {
        if(A==null) return -1;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = A;
        while(!stack.isEmpty() || curr!=null)
        {
            while(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
            curr = stack.pop();
            if(--B == 0) return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}