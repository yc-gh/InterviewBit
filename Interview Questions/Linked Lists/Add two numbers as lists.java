// https://www.interviewbit.com/problems/add-two-numbers-as-lists/

public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if(A==null) return B;
        if(B==null) return A;
        
        ListNode currA = A;
        ListNode currB = B;
        ListNode head = new ListNode(0);
        ListNode curr = head;
        
        int carry = 0;
        while(currA!=null && currB!=null)
        {
            int sum = currA.val + currB.val + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
            currA = currA.next;
            currB = currB.next;
        }
        
        while(currA!=null)
        {
            if(carry==0)
            {
                curr.next = currA;
                break;
            }
            int sum = currA.val + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
            currA = currA.next;
        }
        
        while(currB!=null)
        {
            if(carry==0)
            {
                curr.next = currB;
                break;
            }
            int sum = currB.val + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;
            currB = currB.next;
        }
        
        if(carry>0)
        {
            curr.next = new ListNode(1);
        }
        
        return head.next;
    }
}