// https://www.interviewbit.com/problems/k-reverse-linked-list/

public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        if(A==null) return null;
        ListNode curr = A;
        ListNode prev = null;
        ListNode next = null;
        int count = B;
        while(count-->0 && curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(curr!=null) A.next = reverseList(curr,B);
        return prev;
    }
}