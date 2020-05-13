// https://www.interviewbit.com/problems/combination-sum/

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        backtrack(A, B, 0, res, new ArrayList<>());
        return res;
    }
    
    private static void backtrack(ArrayList<Integer> nums, int k, int start,
                             ArrayList<ArrayList<Integer>> res, ArrayList<Integer> templist)
    {
        if(k<0) return;
        else if(k==0)
        {
            res.add(new ArrayList<>(templist));
        }
        else
        {
            for(int i=start; i<nums.size(); i++)
            {
                if(i>start && nums.get(i)==nums.get(i-1)) continue;
                templist.add(nums.get(i));
                backtrack(nums, k-nums.get(i), i, res, templist);
                templist.remove(templist.size()-1);
            }
        }
    }
}
