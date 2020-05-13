// https://www.interviewbit.com/problems/level-order/

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while(size-->0)
            {
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            res.add(temp);
        }
        
        return res;
    }
}