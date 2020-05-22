// https://www.interviewbit.com/problems/min-jumps-array/

public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, currend = 0, currfarthest = 0;
        for (int i = 0; i < n - 1; i++) {
            currfarthest = Integer.max(currfarthest, i + nums[i]);
            if (i == currend) {
                jumps++;
                currend = currfarthest;
            }
        }
        return currend < n - 1 ? -1 : jumps;
    }
}
