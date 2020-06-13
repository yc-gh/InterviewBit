//https://www.interviewbit.com/problems/all-factors/

public class Solution {
    public int[] allFactors(int A) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=A/i; i++)
        {
            if(A%i==0) 
            {
                list.add(i);
                if(A/i!=i) list.add(A/i);
            }
        }
        Collections.sort(list);
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
