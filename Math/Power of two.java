//https://www.interviewbit.com/problems/power-of-two-integers/

public class Solution {
    public int isPower(int n) {
        if (n <= 1) 
        return 1; 
  
        // for (int i = 2; i<= n/i; i++) { 
        //     double val = Math.log10(n) / Math.log10(i); 
        //     if ((val - (int)val) < 0.00000001) 
        //         return 1; 
        // } 
        for(int i = 2; i<=n/i; i++) 
        { 
           double p = Math.log10(n) / Math.log10(i); 
           if ((Math.ceil(p) == Math.floor(p)) && p > 1) return 1;
        }  
      
        return 0; 
    }
}
