// https://www.interviewbit.com/problems/reverse-bits/

public class Solution {
    public long reverse(long n) {
        if (n == 0) return 0;
        
        long result = 0;
        //Java doesn't have unsigned data types
        //Therefore the sign bit MSB must be ignored
        for (int i = 0; i < 32; i++) {
            //This runs one less time (ignores sign bit)
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}
