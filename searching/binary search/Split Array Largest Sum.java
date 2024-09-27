/*

You’re given an array 'arr' of size 'n' and an integer 'k'.

Your task is to split 'arr' into 'k' sub-arrays such that the maximum sum achieved from the 'k' subarrays formed must be the minimum possible.

A subarray is a contiguous part of the array.

Return the minimum possible value of the maximum sum obtained after splitting the array into 'k' partitions.

Example:
Input: ‘arr’ = [1, 1, 2] and ‘k’ = 2 

Output: 2
*/

import java.util.ArrayList;
public class Solution {
    public static int getcount(int mid,ArrayList<Integer> array)
    {
        int sum=0;
        int count=1;
        for(int i=0;i<array.size();i++)
        {
            if(sum+array.get(i) <=mid)
            {
                sum+=array.get(i);
            }
            else
            {
                count++;
                sum=array.get(i);
            }
        }
        return count;
    }
    public static int binarysearch(ArrayList<Integer> array, int k)
    {
        int n=array.size();
        int low=Integer.MIN_VALUE,high=0;
        for(int i=0;i<n;i++)
        {
            high+=array.get(i);
            low=Math.max(low,array.get(i));
        }
         int ans=0;
        while(low<=high)
        {
         int mid=(low+high)/2;
         int noofsubarrays=getcount(mid,array);
      
       if(noofsubarrays<=k)
         {
           ans=mid;
           high=mid-1;
         }   
         else
         {
          
           low=mid+1;
         }
         

        }
        return ans;

    }
    public static int splitArray(ArrayList<Integer> array, int k) {
        // Write your code here.
        return binarysearch(array, k);
    }
}
