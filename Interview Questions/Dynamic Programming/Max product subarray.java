// https://www.interviewbit.com/problems/max-product-subarray/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] nums) {
        int max = nums[0];
        int tempMax = nums[0];
        int tempMin = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]<0)
            {
                tempMax ^= tempMin;
                tempMin ^= tempMax;
                tempMax ^= tempMin;
            }
            
            tempMax = Integer.max(tempMax*nums[i], nums[i]);
            tempMin = Integer.min(tempMin*nums[i], nums[i]);
            
            if(tempMax > max) max = tempMax;
        }
        
        return max;
    }
}
