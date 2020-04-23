// https://www.interviewbit.com/problems/intersection-of-linked-lists/

public class Solution {
    // 2 ways to think about this
    // 1->
    // c = common part of list 
    // a + c traversed by first list
    // b + c traversed by second
    // after swapping
    // a + c + b + c traversed by first
    // b + c + a + c traversed by second
    
    // 2 -> 
    // Let difference in lengths of lists (excluding common part) is d
    // longer (if different lengths) list takes d extra steps
    // when shorter list step reaches null, longer list step is d dist behind
    // short -> long head
    // long -> d steps to null
    // when long -> short head, newlong has moved d steps ahead
    // equal steps left till intersection point
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if(a==null || b==null) return null;
        ListNode acurr = a;
        ListNode bcurr = b;
        while(acurr!=bcurr)
        {
            acurr = acurr==null ? b : acurr.next;
            bcurr = bcurr==null ? a : bcurr.next;
        }
        
        return acurr;
    }
}
