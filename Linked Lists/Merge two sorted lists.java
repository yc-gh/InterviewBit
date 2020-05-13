// https://www.interviewbit.com/problems/merge-two-sorted-lists/

public class Solution {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if(A==null) return B;
        if(B==null) return A;
        
        ListNode currA = A;
        ListNode currB = B;
        
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        while(currA!=null && currB!=null)
        {
            if(currA.val < currB.val)
            {
                curr.next = currA;
                currA = currA.next;
            }
            else
            {
                curr.next = currB;
                currB = currB.next;
            }
            curr = curr.next;
        }
        
        if(currA!=null)
        {
            curr.next = currA;
        }
        else if(currB!=null)
        {
            curr.next = currB;
        }
        
        return head.next;
    }
}