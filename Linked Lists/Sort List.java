// https://www.interviewbit.com/problems/sort-list/

public class Solution {
    public ListNode sortList(ListNode head) {
        return mergesort(head);
    }
    
    private ListNode mergesort(ListNode head)
    {
        if(head==null || head.next==null) return head;
        ListNode prev=head, slow=head, fast=head;
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        head = mergesort(head);
        slow = mergesort(slow);
        return merge(head, slow);
    }
    
    private ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode curr1=head1, curr2=head2;
        ListNode newhead = new ListNode(0);
        ListNode newprev = newhead;
        while(curr1!=null && curr2!=null)
        {
            if(curr1.val < curr2.val)
            {
                newprev.next = curr1;
                newprev = newprev.next;
                curr1 = curr1.next;
            }
            else
            {
                newprev.next = curr2;
                newprev = newprev.next;
                curr2 = curr2.next;
            }
        }
        
        if(curr1!=null) newprev.next = curr1;
        else newprev.next = curr2; 
        
        return newhead.next;
    }
}
