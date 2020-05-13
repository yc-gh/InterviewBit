// https://www.interviewbit.com/problems/find-duplicate-in-array/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {
        // Floyd's cycle detection
        int slow = A.get(0);
        int fast = A.get(A.get(0));
        
        while(slow!=fast) {
            slow = A.get(slow);
            fast = A.get(A.get(fast));
        }
        
        fast = 0;
        
        while(slow!=fast) {
            slow = A.get(slow);
            fast = A.get(fast);
        }
        
        return slow;
    }
}
