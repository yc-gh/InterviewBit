//https://www.interviewbit.com/problems/matrix-search/

public class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m=matrix.length, n=matrix[0].length;
        int r = getRow(matrix,target);
        int index = Arrays.binarySearch(matrix[r],target);
        return index>=0 ? 1 : 0;
    }
    
    private static int getRow(int[][] matrix, int target)
    {
        int n =matrix[0].length;
        int l=0,r=matrix.length-1;
        while(l<r)
        {
            int mid = (l+r)>>>1;
            if(target<=matrix[mid][n-1]) r=mid;
            else l=mid+1;
        }
        return l;
    }
}
