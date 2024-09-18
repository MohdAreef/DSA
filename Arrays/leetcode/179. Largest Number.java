/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"
*/
class Solution {
    public String largest(int[] nums)
    {
        int n=nums.length;
        String[] arr=new String[nums.length];
        for(int i=0;i<n;i++)
        {
            arr[i]=nums[i]+"";
        }
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                String a=arr[i]+arr[j];
                String b=arr[j]+arr[i];

                if(Double.parseDouble(b)>Double.parseDouble(a))
                {
                    String temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            
            sb.append(arr[i]);
        }
        if(arr[0].equals("0")) return "0";
        return sb.toString();

    }
    public String largestNumber(int[] nums) {
        return largest(nums);
    }
}
