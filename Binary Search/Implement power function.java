//https://www.interviewbit.com/problems/implement-power-function/

public class Solution {
	public int pow(int x, int n, int d) {
	    if(x==0) return 0;
	    long a = x;
	    long res=1;
        long nAbs = Math.abs((long)n);
        while(nAbs>0)
        {
            if((nAbs&1)==1)
            {
                res *= a;
                res %= d;
            }
            nAbs>>=1;
            a = a*a;
            a %= d;
        }
        res = (res+d)%d;
        return n>0 ? (int)res : (int)(1/res);
	}
}

