/*
Given an increasing sorted rotated array arr of distinct integers. The array is right-rotated k times. Find the value of k.
Let's suppose we have an array arr = [2, 4, 6, 9], so if we rotate it by 2 times so that it will look like this:
After 1st Rotation : [9, 2, 4, 6]
After 2nd Rotation : [6, 9, 2, 4]

Examples:

Input: arr = [5, 1, 2, 3, 4]
Output: 1
Explanation: The given array is 5 1 2 3 4. The original sorted array is 1 2 3 4 5. We can see that the array was rotated 1 times to the right.
*/

class Solution {
    public int find(List<Integer> arr)
    {
        int low=0,high=arr.size()-1;
        int index=-1;
        int mini=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            
            if(arr.get(low)<=arr.get(mid))
            {
                if(arr.get(low)<mini)
                {
                    mini=arr.get(low);
                    index=low;
                }
                low=mid+1;
            }
            else
            {
                if(arr.get(mid)<mini)
                {
                    mini=arr.get(mid);
                    index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }
    public int findKRotation(List<Integer> arr) {
        // Code here
        return find(arr);
        
    }
}
