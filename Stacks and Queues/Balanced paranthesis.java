//https://www.interviewbit.com/problems/balanced-parantheses/

public class Solution {
    // public int solve(String a) {
    //     if(a==null || a.length()==0) return 1;
    //     char[] ch = a.toCharArray();
    //     Deque<Character> stack = new ArrayDeque<>();
        
    //     for(char curr : ch)
    //     {
    //         switch(curr)
    //         {
    //             case '(':
    //                 stack.push('(');
    //                 break;
    //             case ')':
    //                 if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
    //                 else return 0;
    //         }
    //     }
        
    //     return stack.isEmpty() ? 1 : 0;
    // }
    
    public int solve(String a)
    {
        char[] ch = a.toCharArray();
        int open = 0;
        for(char curr : ch)
        {
            if(curr=='(') open++;
            else if(open>0) open--;
            else return 0;
        }
        return open==0 ? 1 : 0;
    }
}
