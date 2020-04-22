// https://www.interviewbit.com/problems/list-cycle/

// No extra space but slower
public class Solution {
	public ListNode detectCycle(ListNode a) {
	    if(a==null) return null;
	    ListNode fast = a;
	    ListNode slow = a;
	    
	    do
	    {
	        if(fast==null || fast.next==null) return null;
	        fast = fast.next.next;
	        slow = slow.next;
	    }while(slow!=fast);
	    
	    slow = a;
	    while(slow!=fast)
	    {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    
	    return slow;
	}
}

// Hashing - extra space but faster
public class Solution {
	public ListNode detectCycle(ListNode a) {
	    if(a==null) return null;
	    Set<ListNode> set = new HashSet<>();
	    ListNode curr = a;
	    while(curr!=null)
	    {
	        if(set.contains(curr)) return curr;
	        set.add(curr);
	        curr = curr.next;
	    }
	    return null;
	}
}