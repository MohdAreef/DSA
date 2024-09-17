/*

A peak element is an element that is strictly greater than its neighbors.
Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the 
peaks.
You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside 
the array.
You must write an algorithm that runs in O(log n) time.
*/
//USING BINARY SEARCH
class Solution {
    public int BS(int[] arr)
    {
        int n=arr.length;
        if(n==1) return 0;
        // NOT REQUIRED
        // if(n==2) 
        // {
        //     if(arr[0]>arr[1]) return 0;
        //     return 1;
        // }
        int low=0, high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;

            if(mid-1<0) 
            {
                if(arr[mid]>arr[mid+1])
                return mid;
                else 
                low=mid+1;
            }
            
            else if(mid+1==n )
            {
                if( arr[mid]>arr[mid-1]) return mid;
                else 
                high=mid-1;
            }

            else if(mid-1>=0 && mid+1<n && arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1])
            {
                return mid;
            }

            else if( mid-1>=0 && mid+1<n && arr[mid-1]<arr[mid] && arr[mid]<arr[mid+1])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return -1; //dummy return 
    }
    public int findPeakElement(int[] nums) {

        return BS(nums);
        
    }
}
