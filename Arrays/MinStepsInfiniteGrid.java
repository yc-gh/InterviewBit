// https://www.interviewbit.com/problems/min-steps-in-infinite-grid/

//Find the distance between points using max of absolute coordinate differences

public class Solution {
    
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        if(A.size()<=0 || B.size()<=0 || A.size()!=B.size())
        {
            return 0;
        }
        
        int steps = 0;
        
        int currX = A.get(0);
        int currY = B.get(0);
        
        for(int i=0, size=A.size(); i<size; i++)
        {
            steps += Math.abs(Integer.max(Math.abs(A.get(i)-currX), Math.abs(B.get(i)-currY)));
            currX = A.get(i);
            currY = B.get(i);
        }
        
        return steps;
    }
}