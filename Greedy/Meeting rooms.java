//https://www.interviewbit.com/problems/meeting-rooms/

public class Solution {
    public int solve(int[][] A) {
        if(A==null || A.length==0) return 0;
        Map<Integer,Integer> map = new TreeMap<>();
        
        for(int[] meeting : A)
        {
            int start = meeting[0], end = meeting[1];
            map.put(start, map.getOrDefault(start,0)+1);
            map.put(end, map.getOrDefault(end,0)-1);
        }
        
        int count = 0, maxcount = 0;
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            count += entry.getValue();
            maxcount = Integer.max(maxcount, count);
        }
        
        return maxcount;
    }
    
    // public int solve(int[][] A) {
    //     int start[] = new int[A.length];
    //     int end[] = new int[A.length];
    //     for(int i=0; i<A.length; i++) {
    //         start[i] = A[i][0];
    //         end[i] = A[i][1];
    //     }
    //     Arrays.sort(start);
    //     Arrays.sort(end);
    //     int idx = 0;
    //     int res=0;
    //     for(int i=0; i<start.length; i++) {
    //         if(start[i]>=end[idx]) idx++;
    //         else res++;
            
    //     }
    //     return res;
    // }
}
