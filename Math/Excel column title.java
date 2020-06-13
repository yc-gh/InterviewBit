//https://www.interviewbit.com/problems/excel-column-title/

public class Solution {
    public String convertToTitle(int A) {
        StringBuilder sb = new StringBuilder();
        int n = 26;
        while(A!=0)
        {
            A--;
            sb.insert(0, (char)((A)%26 + 'A'));
            A = (A)/26;
        }
        return sb.toString();
    }
}
