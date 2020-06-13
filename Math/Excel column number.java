//https://www.interviewbit.com/problems/excel-column-number/

public class Solution {
    public int titleToNumber(String A) {
        int res=0, n=26;
        for(char c : A.toCharArray())
        {
            res = res*n + c-'A'+1;
        }
        return res;
    }
}
