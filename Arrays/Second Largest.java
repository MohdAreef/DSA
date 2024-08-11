/*
Given an array arr, return the second largest distinct element from an array. If the second largest element doesn't exist then return -1.

Examples:

Input: arr = [12, 35, 1, 10, 34, 1]
Output: 34
Explanation: The largest element of the array is 35 and the second largest element is 34.
*/
class Solution {
    public int secondlargest(List<Integer> arr)
    {
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)>first)
            {
                second=first;
                first=arr.get(i);
            }
            else if(arr.get(i)>second && arr.get(i)<first)
            {
                second=arr.get(i);
            }
        }
        return second;
    }
    public int print2largest(List<Integer> arr) {
        // Code Here
    return secondlargest(arr);
        
    }
    
}
