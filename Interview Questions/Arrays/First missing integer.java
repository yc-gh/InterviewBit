// https://www.interviewbit.com/problems/first-missing-integer/

public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int size = A.size();
        int i=0;
        while(i<size)
        {
            int curr = A.get(i);
            if(curr<=size && curr>=1 && curr!=A.get(curr-1)) swap(A,curr-1,i);
            else i++;
        }
        
        i=0;
        while(i<size && A.get(i)==i+1) i++;
        return i+1;
    }
    
    private static void swap(ArrayList<Integer> A, int i, int j)
    {
        int temp = A.get(i);
        A.set(i,A.get(j));
        A.set(j,temp);
    }
}
