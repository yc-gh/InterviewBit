//https://www.interviewbit.com/problems/sliding-window-maximum/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] nums, int k) {
        int l=0, r=0, n=nums.length;
        int[] res = new int[n-k+1];
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//         while(pq.size()<k)
//         {
//             pq.offer(nums[r++]);
//         }
        
//         int ind = 0;
//         while(r<n)
//         {
//             res[ind++] = pq.peek();
//             pq.remove(nums[l++]);
//             pq.offer(nums[r++]);
//         }
        
//         res[ind] = pq.peek();
        
//         return res;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        while(r<k)
        {
            while(!dq.isEmpty() && nums[r] > dq.peekLast()) dq.pollLast();
            dq.offerLast(nums[r]);
            r++;
        }
        int ind = 0;
        while(r<n)
        {
            res[ind++] = dq.peekFirst();
            if(nums[l]==dq.peekFirst()) dq.pollFirst();
            while(!dq.isEmpty() && nums[r]>dq.peekLast()) dq.pollLast();
            dq.offerLast(nums[r]);
            l++;
            r++;
        }
        
        res[ind] = dq.peekFirst();
        
        return res;
    }
}
