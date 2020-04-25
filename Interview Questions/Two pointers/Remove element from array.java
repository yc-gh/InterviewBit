// https://www.interviewbit.com/problems/remove-element-from-array/

public class Solution {
    public int removeElement(ArrayList<Integer> a, int b) {
        if(a==null || a.size()==0) return 0;
        int count = 0,j=0;
        for(int i=0; i<a.size(); i++)
        {
            if(a.get(i)!=b) 
            {
                a.set(j++,a.get(i));
                count++;
            }
        }
        return count;
    }
}
