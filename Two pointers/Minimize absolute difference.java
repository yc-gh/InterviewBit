//https://www.interviewbit.com/problems/minimize-the-absolute-difference/

public class Solution {
    public int solve(int[] A, int[] B, int[] C) {
        int i=0, j=0, k=0;
        int ans=Integer.MAX_VALUE;
        
        while(i<A.length && j<B.length && k<C.length)
        {
            int max = Integer.max(Integer.max(A[i],B[j]), C[k]);
            int min = Integer.min(Integer.min(A[i],B[j]), C[k]);
            ans = Integer.min(ans, Math.abs(max-min));
            if(min==A[i]) i++;
            else if(min==B[j]) j++;
            else k++;
        }
        
        return ans;
    }
}
