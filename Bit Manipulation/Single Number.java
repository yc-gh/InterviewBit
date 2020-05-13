// https://www.interviewbit.com/problems/single-number/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] nums) {
        int xor = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            xor ^= nums[i];
        }
        return xor;
    }
}
