// https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode start = new ListNode(0);
        ListNode prev = start;
        ListNode curr = head, next = head.next;
        while (curr != null) {
            while (next != null && next.val == curr.val) {
                next = next.next;
            }
            if (next == curr.next) {
                prev.next = curr;
                prev = prev.next;
            }
            curr = next;
        }
        prev.next = null;
        return start.next;
        
    }
}