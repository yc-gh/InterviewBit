// https://www.interviewbit.com/problems/subset/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(), 0);
        return res;
    }
    
    private void backtrack(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> res, 
        ArrayList<Integer> templist, int start)
    {
        res.add(new ArrayList<>(templist));
        for(int i=start; i<nums.size(); i++)
        {
            templist.add(nums.get(i));
            backtrack(nums, res, templist, i+1);
            templist.remove(templist.size()-1);
        }
    }
}
