//https://www.interviewbit.com/problems/generate-all-parentheses-ii/

public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
    if(n==0) return new ArrayList<String>();
        ArrayList<String> output = new ArrayList<>();
        backtrack(output, new StringBuilder(), 0, 0, n);
        return output;
    }
    
    static void backtrack(ArrayList<String> output, StringBuilder temp, int open, int close, int n)
    {
        if(temp.length() == n<<1)
        {
            output.add(temp.toString());
            return;
        }
        
        if(open < n)
        {
            temp.append("(");
            backtrack(output, temp, open+1, close, n);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close < open)
        {
            temp.append(")");
            backtrack(output, temp, open, close+1, n);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
