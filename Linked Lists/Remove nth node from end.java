// https://www.interviewbit.com/problems/remove-nth-node-from-list-end/

public class Solution {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if(A==null) return null; 
        ListNode fast = A;
        ListNode slow = A;
        while(fast.next!=null)
        {
            fast = fast.next;
            if(B<=0) slow = slow.next;
            B--;
        }
        if(B>0) return A.next;
        slow.next = slow.next.next;
        return A;
    }
}