// https://www.interviewbit.com/problems/palindrome-partitioning/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        backtrack(s, 0, res, new ArrayList<>());
        return res;
    }
    
    private static void backtrack(String s, int start, ArrayList<ArrayList<String>> res, 
                            List<String> templist)
    {
        if(start==s.length()) res.add(new ArrayList<>(templist));
        else
        {
            for(int i=start; i<s.length(); i++)
            {
                if(!isPalindrome(s,start,i)) continue;
                templist.add(s.substring(start,i+1));
                backtrack(s, i+1, res, templist);
                templist.remove(templist.size()-1);
            }
        }
    }
    
    private static boolean isPalindrome(String s, int l, int r)
    {
        while(l<r)
        {
            if(s.charAt(l++)!=s.charAt(r--)) return false;
        }
        return true;
    }
}
