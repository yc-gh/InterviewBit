//https://www.interviewbit.com/problems/sort-by-color/

public class Solution {
	public void sortColors(ArrayList<Integer> nums) {
	    if(nums==null || nums.size()==0) return;
        int n = nums.size();
        int l=0, r=n-1;
        for(int i=0; i<n; i++)
        {
            if(nums.get(i)==0 && i>l)
            {
                int temp = nums.get(i);
                nums.set(i,nums.get(l));
                nums.set(l,temp);
                l++;
                i--;
            }
            else if(nums.get(i)==2 && i<r)
            {
                int temp = nums.get(i);
                nums.set(i,nums.get(r));
                nums.set(r,temp);
                r--;
                i--;
            }
        }
	}
}
