/*

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
====================================================================================================
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
    public ListNode rotateRight(ListNode A, int B) {
        
        if(B < 1) return A;
        
        int length=1, i = 1;
        ListNode temp = A,temp1=A, temp2=A, head = A;
        
        while(temp.next!=null)
        {
            length++;
            temp=temp.next;
        }
        
       //System.out.println(length);
        
        int k = B%length;
        //System.out.println(k);
        while(i <= (length-k) && k>0)
        {
            temp1 = temp2;
            temp2 = temp2.next;
            i++;
        }
        if(i>1)
        {
            temp.next=A;
            temp1.next=null;
            head = temp2;
        }
        return head;
    }
}
