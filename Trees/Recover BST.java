//https://www.interviewbit.com/problems/recover-binary-search-tree/

public class Solution {
    public int[] recoverTree(TreeNode A) {
        TreeNode pre=null, temp=null, first=null, second=null;
        
        while(root!=null)
        {
            if(root.left!=null)
            {
                temp = root.left;
                
                while(temp.right!=null && temp.right!=root) temp=temp.right;
                
                if(temp.right==null)
                {
                    temp.right = root;
                    root = root.left;
                }
                else //Inorder printing done here
                {
                    if(pre!=null && pre.val>root.val)
                    {
                        if(first==null) first = pre;
                        second = root;
                    }
                    
                    temp.right = null;
                    pre = root;
                    root = root.right;
                }
                
                
            }
            else //Inorder printing done here 
            {
                
                if(pre!=null && pre.val>root.val)
                {
                    if(first==null) first = pre;
                    second = root;
                }
                
                pre = root;
                root = root.right;
            }
        }
        
        //Swap nodes if tree needs to be changed
        // if(first!=null && second!=null)
        // {
        //     int t = first.val;
        //     first.val = second.val;
        //     second.val = t;
        // }
        
        int[] res = new int[2];
        res[0] = first.val;
        res[1] = second.val;
        
        Arrays.sort(res);
        return res;
    }
}
