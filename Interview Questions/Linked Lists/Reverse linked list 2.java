// https://www.interviewbit.com/problems/reverse-link-list-ii/

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {    
        if(head==null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iter = dummy;
        
        // Move to one node behind mth node
        for(int i=1; i<m; i++) iter = iter.next;
        
        ListNode start = iter.next; //Start of sub list
        
        ListNode curr = start; 
        ListNode prev = start;
        ListNode next = start.next;
        
        // Reverse list
        for(int i=m; i<=n; i++)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        start.next = curr;
        iter.next = prev;
        
        return dummy.next;
    }
}