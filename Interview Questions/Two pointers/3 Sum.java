// https://www.interviewbit.com/problems/3-sum/

public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        if(A==null || A.size()==0) return 0;
        //Certain test cases can cause overflow
        long res = A.get(0)+A.get(1)+A.get(2);
        Collections.sort(A);
        for(int i=0; i<A.size()-2; i++)
        {
            int start = i+1, end = A.size()-1;
            while(start<end)
            {
                long sum = A.get(i)+A.get(start)+A.get(end);
                if(sum==B) return (int)sum;
                if(sum>B) end--;
                else start++;
                if(Math.abs(sum-B) < Math.abs(res-B)) res = sum;
            }
        }
        return (int)res;
    }
}
