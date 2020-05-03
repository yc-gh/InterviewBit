// https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit(final int[] prices) {
        if(prices.length==0) return 0;
        int profit = 0;
        int currPrice = prices[0];
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i]>currPrice)
            {
                profit += prices[i]-currPrice;
                currPrice = prices[i];
            }
            else currPrice = prices[i];
        }
        return profit;
    }
}
