//https://www.interviewbit.com/problems/reverse-integer/

public class Solution {
    public int reverse(int A) {
        int res = 0;
        while(A!=0)
        {
            int rem = A%10;
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && rem>7)) return 0;
            else if (res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && rem<-8)) return 0;
            res = res*10 + rem;
            // if(res>Integer.MAX_VALUE/10 || res<Integer.MIN_VALUE/10) return 0;
            // res*=10;
            // if(rem>0 && res>Integer.MAX_VALUE-rem || rem<0 && res<Integer.MIN_VALUE-rem)
            // {
            //     System.out.println("res = "+res+" rem="+rem);
            //     return 0; 
            // }
            // res+=rem;
            A/=10;
        }
        return res;
    }
}
