/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
==================================================================================================
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
    public ListNode deleteDuplicates(ListNode A) {
        
        if(A.next==null) return A;
        
        ListNode temp = A.next, tempPrev = A;
        int dupFound = 0;
        
        while(temp!=null)
        {
            if(tempPrev.val != temp.val)
            {
                if(dupFound>0)
                {
                    tempPrev.next = temp;
                    dupFound=0;
                }
                tempPrev = temp;
            }
            else dupFound++;
            
            temp = temp.next;
        }
        if(tempPrev.next!=null)
            tempPrev.next = null;
        return A;
        
    }
}
