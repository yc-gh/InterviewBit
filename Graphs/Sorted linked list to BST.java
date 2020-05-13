// https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public TreeNode sortedListToBST(ListNode a) {
	    if(a==null) return null;
	    ListNode fast=a, slow=a;
	    ListNode prev=null;
	    
	    while(fast!=null && fast.next!=null)
	    {
	        fast = fast.next.next;
	        prev = slow;
	        slow = slow.next;
	    }
	    
	    TreeNode root = new TreeNode(slow.val);
	    root.right = sortedListToBST(slow.next);
	    
	    if(prev!=null) prev.next = null;
	    else a = null;
	    
	    root.left = sortedListToBST(a);
	    
	    return root;
	}
}
