// https://www.interviewbit.com/problems/spiral-order-matrix-i/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        if(A==null || A.size()==0) return new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        int n = A.size() * A.get(0).size();
        int count=0;
        int left=0, right=A.get(0).size()-1, up=0, down=A.size()-1;
        while(count<n)
        {
            for(int j=left; j<=right; j++)
            {
                output.add(A.get(up).get(j));
                count++;
            }
            up++;
            if(count>=n) break;
            for(int i=up; i<=down; i++)
            {
                output.add(A.get(i).get(right));
                count++;
            }
            right--;
            if(count>=n) break;
            for(int j=right; j>=left; j--)
            {
                output.add(A.get(down).get(j));
                count++;
            }
            down--;
            if(count>=n) break;
            for(int i=down; i>=up; i--)
            {
                output.add(A.get(i).get(left));
                count++;
            }
            left++;
        }
        return output;
    }
}
