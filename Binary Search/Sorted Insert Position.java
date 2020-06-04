//https://www.interviewbit.com/problems/sorted-insert-position/

public class Solution {
	public int searchInsert(ArrayList<Integer> nums, int target) {
	    if(nums==null || nums.size()==0) return 0;
        int l=0,r=nums.size();
        while(l<r)
        {
            int mid = l+r>>>1;
            if(nums.get(mid)<target) l=mid+1;
            else r=mid;
        }
        return l;
	}
}
