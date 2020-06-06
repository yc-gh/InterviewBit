//https://www.interviewbit.com/problems/letter-phone/

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0) return res;
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs",
                                "tuv","wxyz"
        };
        backtrack(digits.toCharArray(), mapping, 0, res, new StringBuilder());
        return res;
    }
    
    private static void backtrack(char[] digits, String[] mapping, 
                            int curr, ArrayList<String> res, StringBuilder sb)
    {
        if(curr==digits.length)
        {
            res.add(sb.toString());
            return;
        }
        for(char c : mapping[digits[curr]-'0'].toCharArray())
        {
            sb.append(c);
            backtrack(digits,mapping,curr+1,res,sb);
            sb.setLength(sb.length()-1);
        }
    }
}
