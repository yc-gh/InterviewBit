// https://www.interviewbit.com/problems/postorder-traversal/

// 1 stack
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        if(A==null) return new ArrayList<>();
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = A;
        
        while(true)
        {
            while(curr!=null)
            {
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }
            
            if(stack.isEmpty()) return res;
            curr = stack.pop();
            
            if(!stack.isEmpty() && stack.peek()==curr) curr=curr.right;
            else 
            {
                res.add(curr.val);
                curr = null;
            }
        }
    }
}

// 2 stacks
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        if(A==null) return new ArrayList<>();
        
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        stack1.push(A);
        
        while(!stack1.isEmpty())
        {
            TreeNode curr = stack1.pop();
            stack2.push(curr);
            
            if(curr.left!=null) stack1.push(curr.left);
            if(curr.right!=null) stack1.push(curr.right);
        }
        
        while(!stack2.isEmpty())
        {
            res.add(stack2.pop().val);
        }
        return res;
    }
}
