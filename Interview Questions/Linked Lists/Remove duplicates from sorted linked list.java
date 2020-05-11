//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/

public class Solution {
    public ListNode deleteDuplicates(ListNode A) {
        if(A==null) return A;
        ListNode curr = A;
        ListNode next = A.next;
        while(curr!=null)
        {
            while(next!=null && next.val==curr.val) next = next.next;
            curr.next = next;
            curr = next;
        }
        return A;
    }
}
