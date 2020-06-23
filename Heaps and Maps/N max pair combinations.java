//https://www.interviewbit.com/problems/n-max-pair-combinations/

public class Solution {
    public int[] solve(int[] nums1, int[] nums2) {
        int n=nums1.length;
        if(n==0) return new int[0];
        
        int k = n;
        int[] res = new int[k];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=n-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(pq.size()<k)
                {
                    pq.offer(nums1[i]+nums2[j]);
                }
                else
                {
                    if(nums1[i]+nums2[j] > pq.peek())
                    {
                        pq.poll();
                        pq.offer(nums1[i]+nums2[j]);
                    }
                    else break;
                }
            }
        }
        
        int i=k-1;
        while(k-->0) res[i--] = pq.poll();
        
        return res;
    }
}
