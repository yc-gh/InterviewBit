// https://www.interviewbit.com/problems/merge-k-sorted-lists/

public class Solution {
    
	public ListNode mergeKLists(ArrayList<ListNode> a) {
	    if(a==null || a.size()==0) return null;
	    ListNode head = new ListNode(0);
	    ListNode prev = head;
	    
	    PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2)->n1.val-n2.val);
	    
	    for(ListNode node : a) pq.offer(node);
	    
	    while(!pq.isEmpty())
	    {
	        ListNode top = pq.poll();
	        if(top.next!=null) pq.offer(top.next);
	        prev.next = top;
	        prev = prev.next;
	    }
	    
	    return head.next;
	}
}