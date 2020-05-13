// https://www.interviewbit.com/problems/implement-strstr/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String haystack, final String needle) {
        if(haystack==null || needle==null) return -1;
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len1<len2) return -1;
        else if(len2==0) return 0;
        for(int i=0; i<=len1-len2; i++)
        {
            if(haystack.charAt(i)==needle.charAt(0))
            {
                int l = 0;
                for(l=0; l<len2; l++)
                {
                    int r = len2-1-l;
                    if(haystack.charAt(i+l)==needle.charAt(l)
                        && 
                       haystack.charAt(i+r)==needle.charAt(r)) continue;
                    else break;
                }
                if(l==len2) return i;
            }
        }
        return -1;
    }
}