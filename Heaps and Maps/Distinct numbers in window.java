//https://www.interviewbit.com/problems/distinct-numbers-in-window/

public class Solution {
    public int[] dNums(int[] A, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.length;
        int l=0, r=0;
        while(r<n)
        {
            if(r-l+1 <= k)
            {
                map.put(A[r], map.getOrDefault(A[r],0)+1);
            }
            else
            {
                res.add(map.size());
                if(map.get(A[l])==1) map.remove(A[l]);
                else map.put(A[l],map.get(A[l])-1);
                l++;
                map.put(A[r], map.getOrDefault(A[r],0)+1);
            }
            r++;
        }
        res.add(map.size());
        int[] ans = new int[res.size()];
        for(int i=0; i<res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
