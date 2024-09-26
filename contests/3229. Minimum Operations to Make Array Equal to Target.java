/*
You are given two positive integer arrays nums and target, of the same length.

In a single operation, you can select any subarray of nums and increment each element within that subarray by 1 or decrement each element within that 
subarray by 1.

Return the minimum number of operations required to make nums equal to the array target.

Example 1:

Input: nums = [3,5,1,2], target = [4,6,2,4]

Output: 2

Explanation:

We will perform the following operations to make nums equal to target:
- Increment nums[0..3] by 1, nums = [4,6,2,3].
- Increment nums[3..3] by 1, nums = [4,6,2,4].
*/

class Solution {
    public long minimum(int[] nums, int[] target) {
        int n = nums.length;
        long sum = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = target[i] - nums[i];
        }
        sum = Math.abs(diff[0]);
        for (int i = 1; i < n; i++) {
            if ((diff[i - 1] > 0 && diff[i] < 0) || (diff[i - 1] < 0 && diff[i] > 0)) {
                sum += Math.abs(diff[i]);
            } else if (Math.abs(diff[i]) > Math.abs(diff[i - 1])) {
                sum += (Math.abs(diff[i] - diff[i - 1]));
            }
        }
        return sum;
    }

    public long minimumOperations(int[] nums, int[] target) {
        return minimum(nums, target);
    }
}
