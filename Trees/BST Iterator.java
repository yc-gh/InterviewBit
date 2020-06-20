//https://www.interviewbit.com/problems/bst-iterator/

public class Solution {

    Deque<TreeNode> stack;

    public Solution(TreeNode root) {
        stack = new ArrayDeque<>();
        addAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        addAll(top.right);
        return top.val;
    }
    
    private void addAll(TreeNode root)
    {
        for(; root!=null; root=root.left) stack.push(root);
    }
}
