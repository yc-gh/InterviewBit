// https://www.interviewbit.com/problems/rotate-list/

public class Solution {
    //Find length of array
    //Mod B with len
    //Lastnode -> next = firstnode
    //Set (B-1)th node next = null
    //Return Bth node as new start
    public ListNode rotateRight(ListNode A, int B) {
        if(A==null) return null;
        int n=0;
        ListNode curr = A;
        while(curr.next!=null)
        {
            curr = curr.next;
            n++;
        }
        n++;
        B = B%n;
        if(B==0) return A;
        curr.next = A;
        int k = n-B-1;
        curr = A;
        ListNode start = null;
        while(k-->0)
        {
            curr = curr.next;
        }
        start = curr.next;
        curr.next = null;
        return start;
    }
}