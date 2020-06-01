//https://www.interviewbit.com/problems/square-root-of-integer/

public class Solution {
    public int sqrt(int x) {
        if(x==0) return 0;
        int l=1,r=x;
        while(l<r)
        {
            int mid = l+r+1>>>1;
            if(mid>x/mid) r=mid-1;
            else l=mid;
        }
        return l;
    }
}
