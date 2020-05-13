// https://www.interviewbit.com/problems/rotated-sorted-array-search/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        int size = A.size();
        int left=0, right=size-1;
        
        while(left<right)
        {
            int mid = left+(right-left)/2;
            if(A.get(mid)>A.get(right)) left=mid+1;
            else right=mid;
        }
        
        int rot = left;
        
        left=0;
        right=size-1;
        
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            int rotindex = (mid+rot)%size;
            if(A.get(rotindex)==B) return rotindex;
            else if(A.get(rotindex)<B) left=mid+1;
            else right=mid-1;
        }
        
        return -1;
    }
}
