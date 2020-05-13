// https://www.interviewbit.com/problems/jump-game-array/

// Approach 1 - Reachable index 
public class Solution {
    public int canJump(int[] nums) {
        int reachableIndex = 0;
        for(int currIndex=0; currIndex<nums.length; currIndex++)
        {
            if(currIndex>reachableIndex) return 0;
            else reachableIndex = Integer.max(reachableIndex, nums[currIndex]+currIndex);
        }
    }
}


// Approach 2 - Jumps left
public class Solution {
    public int canJump(int[] nums) {
        int jumps = nums[0];
        for(int i=0; i<nums.length-1; i++) // or nums.length 
        {
            jumps = Integer.max(nums[i], jumps);
            if(jumps<=0) return 0;
            if(jumps+i>=n-1) return 1;
            jumps--;
        }
        return 1;
    }
}
