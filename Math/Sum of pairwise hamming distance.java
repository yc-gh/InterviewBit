//https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int hammingDistance(final int[] arr) {
        int n = arr.length;
        int ans = 0;
  
        for (int i = 0; i < 32; i++) { 
            int count = 0;
            
            for (int j = 0; j < n; j++) 
                if ((arr[j] & (1 << i)) == 0) count++; 
                
            ans += (2L * count * (n - count))%1000000007; 
            ans %= 1000000007;
        } 
          
        return ans;
    }
}
