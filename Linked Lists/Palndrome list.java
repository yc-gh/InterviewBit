// https://www.interviewbit.com/problems/palindrome-list/

public class Solution {
    public int lPalin(ListNode A) {
        return checkPalindrome(A) ? 1 : 0;
    }
    
    private static boolean checkPalindrome(ListNode start)
    {
        if(start==null) return true;
        ListNode fast = start, slow = start;
        
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast!=null) slow = slow.next;
        slow = reverse(slow);
        fast = start;
        while(slow!=null)
        {
            if(slow.val!=fast.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    private static ListNode reverse(ListNode start)
    {
        ListNode prev = null;
        while(start!=null)
        {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start = next;
        }
        return prev;
    }
}