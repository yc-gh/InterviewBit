//https://www.interviewbit.com/problems/k-largest-elements/

public class Solution {
    public int[] solve(int[] A, int B) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(A.length, Collections.reverseOrder());
        // for(int i : A) pq.offer(i);
        Arrays.sort(A);
        int[] ans = new int[B];
        // int k=0;
        // for(int i=1; i<=B; i++) ans[k++] = pq.poll();
        for(int i=0; i<B; i++) ans[i] = A[A.length-i-1];
        return ans;
    }
}
