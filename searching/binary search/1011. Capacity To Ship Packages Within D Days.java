/*
Solved
Medium
Topics
Companies
Hint
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by 
weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), 
(1, 6, 7), (8), (9), (10) is not allowed.
*/


class Solution {
    public int findDays(int[] arr,int mid)
    {
        int count=1;
        int currCap=0;
        for(int i=0;i<arr.length;i++)
        {
            if((currCap+arr[i])<=mid)
            {
              currCap+=arr[i];
            }
            else
            {
              count++;
              currCap=arr[i];
            }
        }
        return count;
    }
    public int findMinCap(int[] arr,int days)
    {
        int low=Integer.MIN_VALUE;
        

        int high=0;
        for(int i=0;i<arr.length;i++) 
        {
            high+=arr[i];
            low=Math.max(low,arr[i]);
        }
      int ans=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int noOfDays=findDays(arr,mid);
         System.out.println(noOfDays);
            if(noOfDays<=days)
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
    public int shipWithinDays(int[] weights, int days) {
        return findMinCap(weights,days);
    }
}
