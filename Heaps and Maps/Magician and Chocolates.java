//https://www.interviewbit.com/problems/magician-and-chocolates/

public class Solution {
    public int nchoc(int A, int[] B) {
        if(B.length==0) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : B) pq.offer(i);
        
        int totalChocs = 0;
        
        while(A-->0)
        {
            if(pq.isEmpty()) break;
            int top = pq.poll();
            totalChocs = (totalChocs%1000000007+top%1000000007)%1000000007;
            totalChocs %= 1000000007;
            pq.offer(top>>1);
        }
        
        return totalChocs%1000000007;
    }
}
