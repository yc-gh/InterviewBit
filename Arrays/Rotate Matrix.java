// https://www.interviewbit.com/problems/rotate-matrix/

public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int r = a.size();
        int c = a.get(0).size();
        reverseRows(a,r);
        transpose(a,r,c);
    }
    
    static void reverseRows(ArrayList<ArrayList<Integer>> a, int r)
    {
        int i=0, j=r-1;
        while(i<j)
        {
            ArrayList<Integer> temp = a.get(i);
            a.set(i,a.get(j));
            a.set(j,temp);
            i++;
            j--;
        }
    }
    
    static void transpose(ArrayList<ArrayList<Integer>> a, int r, int c)
    {
        for(int i=0; i<r; i++)
        {
            for(int j=i; j<c; j++)
            {
                int temp = a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,temp);
            }
        }
    }
}
