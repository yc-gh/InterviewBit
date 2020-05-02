// https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-i/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] A) {
        if(A.length==0) return 0;
        int currmin = A[0];
        int maxprofit = 0;
        for(int i=1; i<A.length; i++)
        {
            if(A[i]<currmin) currmin = A[i];
            else maxprofit = Integer.max(maxprofit, A[i]-currmin);
        }
        return maxprofit;
    }
}
