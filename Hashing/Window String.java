//https://www.interviewbit.com/problems/window-string/

public class Solution {
    public String minWindow(String A, String B) {
        int minstart=0,minLength=Integer.MAX_VALUE;
        int start=0, end=0, counter=B.length();
        
        int[] map = new int[128];
        for(char c : B.toCharArray()) map[c]++;
        
        while(end<A.length())
        {
            char c1 = A.charAt(end);
            if(map[c1]>0) counter--;
            map[c1]--;
            end++;
            
            while(counter==0)
            {
                if(end-start < minLength)
                {
                    minLength = end-start;
                    minstart = start;
                }
                
                char c2 = A.charAt(start);
                map[c2]++;
                if(map[c2]>0) counter++;
                start++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? "" : A.substring(minstart,minstart+minLength);
    }
}
