//https://www.interviewbit.com/problems/diffk/

public class Solution {
    public int diffPossible(int[] A, int B) {
        int i=0;
        int j=1;
        while(j<A.length){
            int diff=A[j]-A[i];
            if(diff==B) return 1;
            else if(diff<B && i<j){j++;}
            else if(diff>B && i<j){i++;}
            if(i==j){j++;}
        }return 0;
    }
}
