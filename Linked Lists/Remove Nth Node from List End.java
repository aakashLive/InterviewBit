/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.
Try doing it using constant additional space.
===============================================================================================================
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
    public ListNode removeNthFromEnd(ListNode A, int B) {
        
        if(B <= 0) B=1;
        
        ListNode temp =A;
        int length=0, count=1;
        
        while(temp!=null)
        {
            length++;
            temp=temp.next;
        }
        
        if(B>=length)
        {
            A=A.next;
            return A;
        }
        
        temp=A;
        while(temp!=null && count!=(length-B))
        {
            temp = temp.next;
            count++;
        }
        
        temp.next = temp.next.next;
        
        return A;
        
    }
}
