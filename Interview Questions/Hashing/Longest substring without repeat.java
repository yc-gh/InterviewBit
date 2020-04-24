// https://www.interviewbit.com/problems/longest-substring-without-repeat/

public class Solution {
    public int lengthOfLongestSubstring(String A) {
        if(A==null) return 0;
        if(A.length()<2) return A.length();
        
        int[] hash = new int[256];
        int maxlen = 0;
        for(int l=0,r=0; r<A.length(); r++)
        {
            char ch = A.charAt(r);
            if(hash[ch]>0) 
            {
                l = Integer.max(l, hash[ch]);
            }
            hash[ch] = r+1;
            maxlen = Integer.max(maxlen, r-l+1);
        }
        return maxlen;
    }
}
