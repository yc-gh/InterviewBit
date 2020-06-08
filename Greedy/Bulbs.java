//https://www.interviewbit.com/problems/bulbs/

public class Solution {
    public int bulbs(int[] A) {
        int count = 0;
        for(int n : A)
        {
            if((count&1)==0)
            {
                if(n==0) count++;
            }
            else 
            {
                if(1-n==0) count++;
            }
        }
        return count;
    }
}
