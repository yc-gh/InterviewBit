//https://www.interviewbit.com/problems/colorful-number/

public class Solution {
    public int colorful(int A) {
        Set<Integer> set = new HashSet<>();
        char[] num = String.valueOf(A).toCharArray();
        int n = num.length;
        for(int i=0; i<n; i++)
        {
            int prod = 1;
            for(int j=i; j<n; j++)
            {
                prod *= (num[j]-'0');
                if(set.contains(prod)) return 0;
                set.add(prod);
            }
        }
        return 1;
    }
}
