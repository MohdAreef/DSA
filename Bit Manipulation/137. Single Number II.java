/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
*/

class Solution {
    public int single(int[] nums) {
        int i;
        int n = nums.length;
        int ones = 0, twos = 0, threes = 0;
        for (i = 0; i < n; i++) {
            ones = (ones ^ nums[i]) & (~twos);
            twos = (twos ^ nums[i]) & (~ones);
            threes = (threes ^ nums[i]) & (~twos);
        }

        return ones;
    }

    public int singleNumber(int[] nums) {

        return single(nums);

    }
}
