//https://www.interviewbit.com/problems/largest-coprime-divisor/

public class Solution {
    public int cpFact(int x, int y) {
        while (gcd(x, y) != 1) { 
            x = x / gcd(x, y); 
        } 
        return x; 
    }
    
    private static int gcd(int a, int b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
