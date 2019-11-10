/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL

================================================================================================================
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
    public ListNode reverseBetween(ListNode A, int B, int C) {
        
        int i = 1;
        ListNode head = A, prev=null, next=null, drop=A, dropNext=A;
        Boolean game=false;
        while(A!=null)
        {
            if(B==1 && i==1)
            {
                dropNext = head;
                game = true;
            }
            if(game == true)
            {
                next = A.next;
                A.next = prev;
                prev = A; 
                A = next;
            }
            else if(i==(B-1))
            {
                drop = A;
                dropNext = drop.next;
                prev = A;
                game = true;
                A=A.next;
            }
            else A=A.next;
                
            if(i >= C)
            {
                if(B!=1)
                {
                    drop.next = prev;
                    dropNext.next = next;
                }
                else
                {
                    dropNext.next = next;
                    head = prev;
                }
                game = false;
            }
            
            i++;
        }
        return head;
    }
}