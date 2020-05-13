// https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A==null) return res;
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode curr = A;
        queue.offer(A);
        boolean evenlevel = true;
        
        while(!queue.isEmpty())
        {
            int levelsize = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while(levelsize-->0)
            {
                curr = queue.poll();
                if(evenlevel) temp.add(curr.val);
                else temp.add(0,curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            evenlevel = evenlevel ? false : true;
            res.add(temp);
        }
        return res;
    }
}