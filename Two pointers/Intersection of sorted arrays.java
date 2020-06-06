//https://www.interviewbit.com/problems/intersection-of-sorted-arrays/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] intersect(final int[] nums1, final int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int k=0,i=0,j=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j]) i++;
            else if(nums1[i]>nums2[j]) j++;
            else
            {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for(Integer ele : list) res[k++] = ele;
        Arrays.sort(res);
        return res;
    }
}
