//https://www.interviewbit.com/problems/permutations/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A==null || A.size()==0) return res;
        int[] nums = new int[A.size()];
        int k=0;
        for(int i : A) nums[k++] = i;
        int n = nums.length;
        backtrack(nums, new boolean[n], res, new ArrayList<>());
        return res;
    }
    
    private static void backtrack(int[] nums, boolean[] vis, 
                                  ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp)
    {
        if(temp.size()==nums.length) 
        {
            res.add(new ArrayList(temp));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(!vis[i]) 
            {
                temp.add(nums[i]);
                vis[i] = true;
                backtrack(nums, vis, res, temp);
                temp.remove(temp.size()-1);
                vis[i] = false;
            }
        }
    }
}
