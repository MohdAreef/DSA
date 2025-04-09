/*
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
*/
class Solution {
    public int countSubArrays(int[] nums,int k)
    {
        int l=0,r=0,n=nums.length,count=0;
        HashMap<Integer,Integer> map=new HashMap<>();

        while(r<n)
        {
           map.put(nums[r],map.getOrDefault(nums[r],0)+1);

           while(map.size() > k)
           {
            map.put(nums[l],map.get(nums[l])-1);
            if(map.get(nums[l])==0) map.remove(nums[l]);
            l++;
           }
         
         count += (r-l+1);
         r++;

        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        int a=countSubArrays(nums,k-1);
        int b=countSubArrays(nums,k);

        return b-a;
    }
}
