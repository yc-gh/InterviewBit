//https://www.interviewbit.com/problems/path-to-given-node/

public class Solution {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> path = new ArrayList<>();
        preorder(A, B, path);
        return path;
    }
    
    private static boolean preorder(TreeNode root, int target, ArrayList<Integer> path)
    {
        if(root==null) return false;
        
        path.add(root.val);
        
        if(root.val==target) return true;
        
        if(preorder(root.left, target, path)) return true;
        if(preorder(root.right, target, path)) return true;
        
        path.remove(path.size()-1);
        return false;
    }
}
