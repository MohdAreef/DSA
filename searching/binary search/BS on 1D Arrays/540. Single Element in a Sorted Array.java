/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 */

class Solution {
    public int BS(int[] arr)
    {
        int n=arr.length;
        if(n==1) return arr[0];
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mid-1>=0 && mid+1 < n && arr[mid-1]!=arr[mid] && arr[mid]!=arr[mid+1])
            {
             return arr[mid];
            }
            if(mid-1<0 && arr[mid]!=arr[mid+1]) return arr[mid];
            if(mid+1==n && arr[mid]!=arr[mid-1]) return arr[mid];
             // mid is at even index
            else if(mid%2==0)
            {
                // odd -- even
                 if(arr[mid-1]==arr[mid])
                 {
                   high=mid-2;
                 }
                 // even -- odd
                 else
                 {
                   low=mid+2;
                 }
            }
            // mid is at odd index
            else 
            {
                // even -- odd
                if(arr[mid-1]==arr[mid])
                {
                    low=mid+1;
                }
                //odd -- even
                else 
                {
                   high=mid-1;
                }
            }

        }
        return -1; //dummy return
    }
    public int singleNonDuplicate(int[] nums) {
        return BS(nums);
    }
}
