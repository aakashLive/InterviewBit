// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
// Return the sum of the three integers.

// Assume that there will only be one solution

// Example: 
// given array S = {-1 2 1 -4}, 
// and target = 1.

// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        
        int i,j,k,n=A.size(),returnSum=0,sum=0,min=Integer.MAX_VALUE,diff;
        
        Collections.sort(A);
        
        for(i = 0; i < n-2; i++)
        {
            j = i+1;
            k = n-1;
            while(j < k)
            {
                sum = A.get(i) + A.get(j) + A.get(k);
                diff = Math.abs(sum-B);
                if(diff == 0)
                    return sum;
                if(diff < min)
                {
                    min = diff;
                    returnSum = sum;
                }
                if(sum < B)
                {
                    j++;
                }
                else if(sum > B)
                {
                    k--;
                }
            }
        }
        return returnSum;
        
        // for(i=0;i<=n-3;i++)
        // {
        //     for(j=i+1;j<=n-2;j++)
        //     {
        //         for(k=j+1;k<=n-1;k++)
        //         {
        //             sum = A.get(i) + A.get(j) + A.get(k);
        //             diff = Math.abs(sum - B);
        //             if(min>diff)
        //             {
        //                 min=diff;
        //                 returnSum=sum;
        //             }
        //         }
        //     }
        // }
        // return returnSum;
    }
}
