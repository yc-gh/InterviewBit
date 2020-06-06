//https://www.interviewbit.com/problems/equal/

public class Solution {
    public int[] equal(int[] a) {
        if(a==null || a.length==0) return new int[0];
        List<int[]> list = new ArrayList<>();
        Map<Integer,int[]> map = new HashMap<>();
        int n = a.length;
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int sum = a[i]+a[j];
                if(map.containsKey(sum))
                {
                    int[] mapping = map.get(sum);
                    if(i!=mapping[0] && i!=mapping[1] && j!=mapping[0] && j!=mapping[1])
                        list.add(new int[]{mapping[0],mapping[1],i,j});
                }
                else
                {
                    map.put(sum, new int[]{i,j});
                }
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y)
            {
                if(x[0]==y[0]) 
                {
                    if(x[1]==y[1])
                    {
                        if(x[2]==y[2])
                        {
                            return x[3]-y[3];
                        }
                        return x[2]-y[2];
                    }
                    return x[1]-y[1];
                }
                return x[0]-y[0];
            }
        });
        if(list.isEmpty()) return new int[0]; // No solution
        int[] res = new int[4];
        for(int i=0; i<list.get(0).length; i++) res[i] = list.get(0)[i];
        return res;
    }
}
