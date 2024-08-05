/*
Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer 
in any order.

You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
*/

class Solution {
    public int[] single(int[] nums) {
        int i;
        int total = 0;
        for (i = 0; i < nums.length; i++) {
            total = total ^ nums[i];
        }
        System.out.println("total" + total);

        int newnumber = (total ^ (total - 1)) & total;
        System.out.println("newnumber" + newnumber);
        int bucket1 = 0, bucket2 = 0;
        for (i = 0; i < nums.length; i++) {
            if ((newnumber & nums[i]) == newnumber) {
                bucket1 ^= nums[i];
            } else {
                bucket2 ^= nums[i];
            }
        }
        int[] res = new int[] { bucket1, bucket2 };
        return res;
    }

    public int[] singleNumber(int[] nums) {
        return single(nums);

    }
}
