//https://www.interviewbit.com/problems/reverse-level-order/

public class Solution {
    public ArrayList<Integer> solve(TreeNode A) {
        if(A==null) return new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.offer(A);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
                TreeNode front = queue.poll();
                res.add(front.val);
                if(front.right!=null) queue.offer(front.right);
                if(front.left!=null) queue.offer(front.left);
        }
        
        Collections.reverse(res);
        
        return res;
    }
}
