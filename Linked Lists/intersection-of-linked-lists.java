// Write a program to find the node at which the intersection of two singly linked lists begins.

// For example, the following two linked lists:

// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗
// B:     b1 → b2 → b3

// begin to intersect at node c1.

//  Notes:
// 1. If the two linked lists have no intersection at all, return null.
// 2. The linked lists must retain their original structure after the function returns.
// 3. You may assume there are no cycles anywhere in the entire linked structure.
// 4. Your code should preferably run in O(n) time and use only O(1) memory.
//=*=*=========================================================================================

//Solution:
{
    public int size(ListNode start)
    {
        int size = 0;
        while(start!=null)
        {
            size++;
            start = start.next;
        }
        return size;
    }
    
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        
        int aSize = size(a);
        int bSize = size(b);
        
        // int larger = aSize>bSize ? aSize : bSize;
        
        int diff = aSize - bSize;
        
        if(bSize>aSize)
        {
            ListNode temp = a;
            a = b;
            b = temp;
            diff = bSize - aSize;
        }
        
        for(int i=0;i<diff;i++)
        {
            a = a.next;
        }
        
        while(a!=null && b!=null)
        {
            if(a==b)
                return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }
}