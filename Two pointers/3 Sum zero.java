//https://www.interviewbit.com/problems/3-sum-zero/

public class Solution {
    public int[][] threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new int[0][0];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){
                long sum = (long)nums[i]+(long)nums[j]+(long)nums[k]; //1 test case has Int max and min 
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        int[][] ans = new int[res.size()][3];
        int k=0;
        for(List<Integer> list : res)
        {
            int[] temp = new int[3];
            int j=0;
            for(int i : list) temp[j++] = i;
            ans[k++] = temp;
        }
        return ans;
    }
}
