//https://www.interviewbit.com/problems/array-3-pointers/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int p=A.length, q=B.length, r=C.length;
        int i=0, j=0, k=0;
        int minDiff = Integer.MAX_VALUE;
        while(i<p && j<q && k<r)
        {
            int min = Integer.min(A[i],Integer.min(B[j],C[k]));
            int max = Integer.max(A[i],Integer.max(B[j],C[k]));
            if(max-min < minDiff) minDiff = max-min;
            if(minDiff==0) return minDiff;
            if(A[i]==min) i++;
            else if(B[j]==min) j++;
            else k++;
        }
        return minDiff;
    }
}
