//https://www.interviewbit.com/problems/diffk-ii/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int diffPossible(final int[] A, int B) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<A.length; i++)
        {
            if(map.containsKey(A[i]-B) || map.containsKey(A[i]+B)) return 1;
            map.put(A[i],i);
        }
        return 0;
    }
}
