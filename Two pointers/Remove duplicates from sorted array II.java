//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/

public class Solution {
	public int removeDuplicates(ArrayList<Integer> nums) {
	    if(nums==null || nums.size()==0) return 0;
        int k=0;
        for(int i=1; i<nums.size(); i++)
        {
            if((nums.get(i)).equals(nums.get(k)))
            {
                if(k==0 || !(nums.get(k)).equals(nums.get(k-1)))
                {
                    k++;
                    int temp = nums.get(i);
                    nums.set(i,nums.get(k));
                    nums.set(k,temp);
                }
            }
            else
            {
                k++;
                int temp = nums.get(i);
                nums.set(i,nums.get(k));
                nums.set(k,temp);
            }
        }
        return k+1;
	}
}
