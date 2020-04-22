// https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/

public class Solution {
    public TreeNode buildTree(int[] in, int[] post) {
        return buildTreeUtil(in,post,0,in.length-1,new int[]{post.length-1});
    }
    
    private static TreeNode buildTreeUtil(int[] in, int[] post, int l, int r, int[] pIndex)
    {
        if(l>r) return null;
        
        TreeNode root = new TreeNode(post[pIndex[0]]);
        pIndex[0]--;
        
        int inIndex = inoIndex(in,l,r,root.val);
        
        root.right = buildTreeUtil(in, post, inIndex+1, r, pIndex);
        root.left = buildTreeUtil(in, post, l, inIndex-1, pIndex);
        
        return root;
    }
    
    private static int inoIndex(int[] in, int l, int r, int key)
    {
        int index = l;
        for(int i=l; i<=r; i++)
        {
            if(in[i]==key) 
            {
                index = i;
                break;
            }
        }
        return index;
    }
}
