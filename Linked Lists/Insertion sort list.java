// https://www.interviewbit.com/problems/insertion-sort-list/

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode start = new ListNode(0);
        ListNode iter = start;
        ListNode curr = head;
        ListNode next = curr.next;
        
        while(curr!=null)
        {
            next = curr.next;
            if(iter.val >= curr.val) iter = start;
            while(iter.next!=null && iter.next.val<curr.val)
            {
                iter = iter.next;
            }
            curr.next = iter.next;
            iter.next = curr;
            //iter = start; Don't iterate from start each time
            //Set iter to start only if the iter element is bigger than current ele
            // i.e a smaller element needs to be inserted
            curr = next;
        }
        return start.next;
    }
}