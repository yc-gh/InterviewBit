//https://www.interviewbit.com/problems/partition-list/

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        
        ListNode leftStart = new ListNode(0);
        ListNode leftprev=leftStart;
        ListNode rightStart = new ListNode(0);
        ListNode rightprev=rightStart;
        
        ListNode curr = head;
        while(curr!=null)
        {
            if(curr.val < x)
            {
                leftprev.next = curr;
                leftprev = curr;
            }
            else
            {
                rightprev.next = curr;
                rightprev = curr;
            }
            curr = curr.next;
        }
        
        rightprev.next = null;
        leftprev.next = rightStart.next;
        
        return leftStart.next;
    }
}
