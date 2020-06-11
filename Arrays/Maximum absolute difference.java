//https://www.interviewbit.com/problems/maximum-absolute-difference/

public class Solution {
    public int maxArr(int[] A) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++)
        {
            max1 = Integer.max(max1, A[i]+i);
            max2 = Integer.max(max2, A[i]-i);
            min1 = Integer.min(min1, A[i]+i);
            min2 = Integer.min(min2, A[i]-i);
        }
        return Integer.max(max1-min1, max2-min2);
    }
}
