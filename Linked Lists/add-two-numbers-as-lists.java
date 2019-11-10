/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807

Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.

==================================================================================================================================================================
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
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        
        int carry = 0;
        int sum = 0;
        ListNode resultHead=null, temp=null;
        
        
        while(A!=null || B!=null || carry>0)
        {
            if(A!=null)
                sum += A.val;
            if(B!=null)
                sum += B.val;
            sum += carry;
            
            carry = 0;
            
            if(sum>=10)
            {
                carry = 1;
                sum = sum%10;
            }
            
            ListNode resultNode = new ListNode(sum);
            sum=0;
            resultNode.next = null;
            
            if(resultHead==null)
            {
                resultHead = resultNode;
                temp = resultNode;
            }
            else
            {
                temp.next = resultNode;
                temp = resultNode;
            }
            
            //A.val = sum;
            
            A=A!=null ? A.next : A;
            B=B!=null ? B.next : B;
        }
        return resultHead;
    }
}
