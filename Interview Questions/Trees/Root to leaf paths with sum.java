// https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/

public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        pathSumUtil(A, B, new ArrayList<Integer>(), res, 0);
        return res;
    }
    
    private static void pathSumUtil(TreeNode root, int key, 
        ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res, int sum)
    {
        if(root==null) 
        {
            return ;
        }
        temp.add(root.val);
        sum += root.val;
        if(root.left==null && root.right==null)
        {
            if(sum==key)
            {
                res.add(new ArrayList(temp));
            }
        }
        pathSumUtil(root.right, key, temp, res, sum);
        pathSumUtil(root.left, key, temp , res, sum);
        temp.remove(temp.size()-1);
        return;
    }
}