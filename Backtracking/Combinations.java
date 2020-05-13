// https://www.interviewbit.com/problems/combinations//

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, res, new ArrayList<>());
        return res;
    }
    
    private static void backtrack(int n, int k, int start, 
                                  ArrayList<ArrayList<Integer>> res, ArrayList<Integer> templist)
    {
        if(k==0)
        {
            res.add(new ArrayList<>(templist));
            return;
        }
        for(int i=start; i<=n; i++)
        {
            templist.add(i);
            backtrack(n, k-1, i+1, res, templist);
            templist.remove(templist.size()-1);
        }
    }
}
