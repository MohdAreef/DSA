/*
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
*/


class Solution {
    public int isPossible(int mid,int[] arr,int k)
    {
        int currsum=0;
        int cnt=1;
        for(int i=0;i<arr.length;i++)
        {
            if(currsum+arr[i]<=mid)
            {
                currsum+=arr[i];
            }
            else
            {
                currsum=arr[i];
                cnt++;
            }
        }
     return cnt;
    }
    public int split(int[] arr,int k)
    {
        int n=arr.length;
        int low=0;
       int  high=0;
       int ans=-1;
        for(int i=0;i<n;i++)
        {
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }
        while(low<=high)
        {
            int mid=(low+high)/2;
            int temp=isPossible(mid,arr,k);
            if(temp>k)
            {
              
                low=mid+1;
            }
            else
            {
                ans=mid;
                high=mid-1;
            }
        }
        return ans;

    }
    public int splitArray(int[] nums, int k) {
        return split(nums,k);
    }
}
