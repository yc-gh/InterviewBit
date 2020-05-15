// https://www.interviewbit.com/problems/reorder-list/

public class Solution {
    public ListNode reorderList(ListNode head) {
        if (head == null)
            return head;
        ListNode prev = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode revStart = reverse(slow);
        combine(head, revStart);
        return head;
    }

    private void combine(ListNode head1, ListNode head2) {
        ListNode start = new ListNode(0);
        ListNode prev = start;
        ListNode curr1 = head1, curr2 = head2;
        while (curr1 != null && curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            prev.next = curr1;
            curr1.next = curr2;
            prev = curr2;
            curr1 = next1;
            curr2 = next2;
        }

        if (curr2 != null) {
            prev.next = curr2;
            prev = curr2;
        }
        prev.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
