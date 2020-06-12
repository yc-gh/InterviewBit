//https://www.interviewbit.com/problems/palindrome-integer/

public class Solution {
    public int isPalindrome(int num) {
        if(num<0) return 0;
        int div=1;
        while(num/div>=10) div*=10;
        while(div>=1)
        {
            int first = (num/div)%10;
            int last = num%10;
            if(first!=last) return 0;
            num/=10;
            div/=100;
        }
        return 1;
    }
}
