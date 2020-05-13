// https://www.interviewbit.com/problems/power-of-2/

import java.math.BigInteger;

public class Solution {
    public int power(String n) {
        BigInteger num = new BigInteger(n);
        if(num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE)) return 0;
        return num.bitCount()==1 ? 1 : 0;
    }
}
