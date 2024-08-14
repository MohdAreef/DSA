/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

class Solution {
    public int threesum(int[] nums, int target) {
        int distance = Integer.MAX_VALUE;
        int sum = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;

            while (l < r) {
                int temp = nums[i] + nums[l] + nums[r];
                int dist = Math.abs(temp - target);

                if (dist < distance) {
                    sum = temp;
                    distance = dist;
                } else if (dist == distance) {
                    if (temp < target) {
                        sum = temp;
                    }
                }

                if (temp < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return sum;
    }

    public int threeSumClosest(int[] nums, int target) {
        return threesum(nums, target);
    }
}
