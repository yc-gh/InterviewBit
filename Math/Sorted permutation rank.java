//https://www.interviewbit.com/problems/sorted-permutation-rank/

public class Solution {
    static int fact(int n) 
    { 
        return (n<=1) ? 1 : ((n%1000003)*(fact(n-1)%1000003))%1000003;
    } 
  
    static int findSmallerInRight(String str, int low, 
                                  int high) 
    { 
        int countRight = 0, i; 
  
        for (i = low + 1; i <= high; ++i) 
            if (str.charAt(i) < str.charAt(low)) 
                countRight = countRight+1; 
  
        return countRight; 
    } 
  
    static int findRank(String str) 
    { 
        int len = str.length(); 
        int rank = 1; 
        int countRight; 
  
        for (int i = 0; i < len; ++i) { 
            int mul = fact(len-i-1);
  
            countRight = findSmallerInRight(str, i, len - 1); 
            
            rank += ((countRight%1000003) * (mul%1000003))%1000003;
            rank%=1000003;
        } 
  
        return rank; 
    }
}
