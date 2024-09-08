/*
You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
*/

class Solution {
    public int findDays(int mid, int[] arr, int k) {
        int count = 0;
        int temp = k;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= mid) {
                temp--;

                if (temp == 0) {
                    count++;
                    temp = k;
                }
            } else {
                temp = k;
            }
        }
        return count;
    }

    public int min(int[] arr, int m, int k) {
        int low = 1;
        int high = 0;
        for (int i = 0; i < arr.length; i++) {
            high = Math.max(high, arr[i]);
        }
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            int noofflowers = findDays(mid, arr, k);

            if (noofflowers >= m) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int minDays(int[] arr, int m, int k) {
        return min(arr, m, k);
    }
}
