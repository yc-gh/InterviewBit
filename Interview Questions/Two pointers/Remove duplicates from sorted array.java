// https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/

public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        int i = 0;
        for(int n : a)
        {
            if(n>a.get(i))
                a.set(++i, n);
        }
        return i+1;
    }
}
