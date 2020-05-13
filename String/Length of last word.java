// https://www.interviewbit.com/problems/length-of-last-word/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String s) {
        int n = s.length();
        if(n==0) return 0;        
        int len = 0, j=n-1;
        while(j>=0 && s.charAt(j)==' ') j--;
        while(j>=0 && s.charAt(j)!=' ') 
        {
            len++;
            j--;
        }
        return len;
    }
}
