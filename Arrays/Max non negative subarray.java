//https://www.interviewbit.com/problems/max-non-negative-subarray/

public class Solution {
    public int[] maxset(int[] A) {
        int n = A.length;
        long sum=0, maxsum=0;
        int start=0,end=-1,maxstart=-1,maxend=-1;
        int len=0,maxlen=0;
        int i=0;
        for(;i<n;i++)
        {
            if(A[i]>=0)
            {
                sum+=A[i];
                len++;
                end++;
            }
            else if(A[i]<0)
            {
                len=0;
                sum=0;
                start=i+1;
                end=i;
            }
            if(sum>maxsum)
            {
                maxsum=sum;
                maxstart=start;
                maxend=end;
                maxlen=len;
            }
            else if(sum==maxsum && len>maxlen)
            {
                maxlen=len;
                maxstart=start;
                maxend=end;
            }
        }
        int[] res = new int[maxlen];
        if(maxstart!=-1 && maxend!=-1)
        {
            int k=0;
            for(i=maxstart; i<=maxend; i++)
            {
                res[k++] = A[i];
            }
        }
        return res;
    }
}
