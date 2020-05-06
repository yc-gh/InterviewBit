// https://www.interviewbit.com/problems/distribute-candy/

public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        //Adjust for left neighbor
        for(int i=1; i<n; i++)
        {
            if(ratings[i]>ratings[i-1]) candies[i]=candies[i-1]+1;
        }
        
        //Adjust for right neighbor
        for(int i=n-2; i>=0; i--)
        {
            if(ratings[i]>ratings[i+1])                                 
                candies[i]=Integer.max(candies[i],candies[i+1]+1);
        }
        
        int total = Arrays.stream(candies).sum();
        
        return total;
    }
}
