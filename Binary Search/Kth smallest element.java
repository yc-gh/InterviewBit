//https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int l=A[0], r=A[0];
        
        for(int i : A) 
        {
            if(i < l) l = i;
            if(i > r) r = i;
        }
        
        B--;
        while(l < r)
        {
            int mid = l+r>>>1;
            int count = getCount(A,mid);
            if(count > B) r=mid;
            else l=mid+1;
        }
        
        return l;
    }
    
    private static int getCount(final int[] A, int ele)
    {
        int count = 0;
        for(int i : A) if(i<=ele) count++;
        return count;
    }
}


//Alternative approach
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int l=A[0], r=A[0];
        
        for(int i : A) 
        {
            if(i < l) l = i;
            if(i > r) r = i;
        }
        
        B--;
        while(l < r)
        {
            int mid = (l+r>>>1)+1;
            int count = getCount(A,mid);
            if(count > B) r=mid-1;
            else l=mid;
        }
        
        return l;
    }
    
    private static int getCount(final int[] A, int ele)
    {
        int count = 0;
        for(int i : A) if(i<ele) count++;
        return count;
    }
}
