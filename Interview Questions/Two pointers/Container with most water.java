// https://www.interviewbit.com/problems/container-with-most-water/

public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        if(A==null || A.size()==0) return 0;
        
        int l=0, r=A.size()-1;
        int max = 0;
        while(l<r)
        {
            int curr = (r-l)*Integer.min(A.get(l), A.get(r));
            if(curr>max) max = curr;
            if(A.get(l)<A.get(r)) l++;
            else r--;
        }
        return max;
    }
}
