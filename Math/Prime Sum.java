//https://www.interviewbit.com/problems/prime-sum/

public class Solution {
    public int[] primesum(int n) {
        boolean[] primes = SieveOfEratosthenes(n);
        int[] ans = new int[2];
        for(int i=2; i<n-1; i++)
        {
            if(primes[i] && primes[n-i]) 
            {
                ans[0] = i;
                ans[1] = n-i;
                break;
            }
        }
        return ans;
    }
    
    private static boolean[] SieveOfEratosthenes(int n)
    {
         boolean[] isPrime = new boolean[n];
         Arrays.fill(isPrime,true);
         
         for(int i=2; i<=n/i; i++)
         {
             if(!isPrime[i]) continue;
             for(int j=i*i; j<n; j+=i) isPrime[j] = false;
         }
         
         return isPrime;
    }
}
