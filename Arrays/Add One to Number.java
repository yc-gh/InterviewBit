//https://www.interviewbit.com/problems/add-one-to-number/

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int j=0;
        if(digits[0]==0)
        {
            while(j<n && digits[j]==0) j++; 
            digits = Arrays.copyOfRange(digits,j,n);
            n = digits.length;
        }
        for(int i=n-1; i>=0; i--)
        {
            if(digits[i]<9) 
            {
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;
        }
        
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}
