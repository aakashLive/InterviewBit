// Remove duplicates from Sorted Array
// Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

// Note that even though we want you to return the new length, make sure to change the original array as well in place

// Do not allocate extra space for another array, you must do this in place with constant memory.

//  Example: 
// Given input array A = [1,1,2],
// Your function should return length = 2, and A is now [1,2]. 

public class Solution {
    public int removeDuplicates(ArrayList<Integer> a) {
        if(a.isEmpty()) return 0;
        int i=a.size()-1;
        while((i-1)>=0)
        {
            if(a.get(i).equals(a.get(i-1)))
            {
                a.remove(i);
            }
            i--;
        }
        return a.size();
        
        
    }
}