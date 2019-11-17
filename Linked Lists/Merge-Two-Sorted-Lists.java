/*Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20

==============================================================================================================================
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
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        
        if(A==null) return B;
        if(B==null) return A;
        
        ListNode tempA = A, tempB = B, head=null, tail=null;
        
        while(tempA!=null && tempB!=null)
        {
            ListNode newNode=null;
            
            if(tempA.val <= tempB.val)
            {
                newNode = new ListNode(tempA.val);
                tempA = tempA.next;
            }
            else if(tempA.val > tempB.val)
            {
                newNode = new ListNode(tempB.val);
                tempB = tempB.next;
            }
            
            if(head == null)
            {
                head = newNode;
                tail = newNode;
            }
            else
            {
                tail.next = newNode;
                tail = newNode;
            }
            newNode.next = null;
        }
        
        if(tempA!=null) tail.next = tempA;
        else if(tempB!=null) tail.next = tempB;
        
        return head;
        
    }
}
