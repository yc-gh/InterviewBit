// https://www.interviewbit.com/problems/max-sum-contiguous-subarray/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int res = A.get(0);
        int sum = A.get(0);
        for(int i=1; i<A.size();  i++)
        {
            sum = Integer.max(A.get(i), sum+A.get(i));
            res = Integer.max(res, sum);
        }
        
        return res;
    }
}
