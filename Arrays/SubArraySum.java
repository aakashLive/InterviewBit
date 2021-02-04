/*
Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.

 

Example 1:

Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.
 

Example 2:

Input:
N = 10, S = 15
A[] = {1,2,3,4,5,6,7,8,9,10}
Output: 1 5
Explanation: The sum of elements 
from 1st position to 5th position
is 15.
 

Your Task:
You don't need to read input or print anything. The task is to complete the function subarraySum() which takes arr, N and S as input parameters and returns a list containing the starting and ending positions of the first such occurring subarray from the left where sum equals to S. The two indexes in the list should be according to 1-based indexing. If no such subarray is found, return -1. 

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
1 <= Ai <= 1010


==========================================================================
*/
//Driver Code Starts

import java.util.*;
import java.lang.*;
import java.io.*;

class SubArraySum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Subarray obj = new Subarray();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}
//Driver Code Ends


class Subarray{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) {
        
        int curr_sum = arr[0], start = 0, i;
        ArrayList<Integer> res = new ArrayList<>();
        
        for (i = 1; i <= n; i++) {
            
            while (curr_sum > sum && start < i - 1) { 
                curr_sum = curr_sum - arr[start]; 
                start++; 
            } 
            
            if (curr_sum == sum) { 
                res.add(start+1);
                res.add(i);
                return res; 
            } 
            
            if (i < n) 
                curr_sum = curr_sum + arr[i]; 
        }

        res.add(-1);
        return res;
    }
}