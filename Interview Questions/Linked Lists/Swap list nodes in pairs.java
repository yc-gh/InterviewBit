// https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/

public class Solution {
    public ListNode swapPairs(ListNode A) {
        if(A==null) return null;
        int count = 2;
        ListNode curr = A;
        ListNode prev = null;
        ListNode next = null;
        while(count-->0 && curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(curr!=null) A.next = swapPairs(curr);
        return prev;
    }
}