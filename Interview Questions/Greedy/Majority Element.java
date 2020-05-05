// https://www.interviewbit.com/problems/majority-element/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>1];
    }
}
