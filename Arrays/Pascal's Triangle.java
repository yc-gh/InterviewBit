https://www.interviewbit.com/problems/pascal-triangle/

//Each row has a 1 at beginning and end
//For each column starting from 1, get sum of current and previous column of previous row 

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<A; i++)
        {
            res.add(new ArrayList<Integer>());
            
            res.get(i).add(1);
            
            for(int j=1; j<i; j++)
            {
                res.get(i).add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            
            if(i>0)
            {
                res.get(i).add(1);
            }
        }
        
        return res;
    }
}