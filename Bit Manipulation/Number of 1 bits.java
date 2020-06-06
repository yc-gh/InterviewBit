//https://www.interviewbit.com/problems/number-of-1-bits/

public class Solution {
	public int numSetBits(long n) {
	    int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                count++;
            n = n >>> 1;
        }

        return count;
	}
}
