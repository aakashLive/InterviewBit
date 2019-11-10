/*
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.

===================================================================================================================================

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
    ListNode fastPtr, slowPtr, prevSlowPtr, mid, secondHead;
    
    public int lPalin(ListNode A) {
        
     fastPtr = A;
     slowPtr = A;
     prevSlowPtr = A;
     mid = null;
     int result = 1;
     
     if(A!=null && A.next!=null)
     {
         while(fastPtr!=null && fastPtr.next!=null)
         {
             fastPtr = fastPtr.next.next;
             prevSlowPtr = slowPtr;
             slowPtr = slowPtr.next;
         }
         
         if(fastPtr!=null)
         {
             mid = slowPtr;
             slowPtr = slowPtr.next;
         }
         
         secondHead = slowPtr;
         
         reverse();
         
         prevSlowPtr.next = null;
         
         ListNode one = A, two = secondHead;
         while(one!=null && two!=null)
         {
            if(one.val == two.val) 
            {
                one = one.next;
                two = two.next;
            }
            else return 0;
         }
         if(one==null && two== null)
         {
             result = 1;
         }
         reverse();
         
         if(mid!=null)
         {
             prevSlowPtr.next = mid;
             mid.next = secondHead;
         }
         else
            prevSlowPtr.next = secondHead;
     }
     return result;
    }
    
    public void reverse()
    {
        ListNode prev = null;
        ListNode curr = secondHead;
        ListNode next = null;
         
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        secondHead = prev;
    }
}