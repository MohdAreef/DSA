/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has 
less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.
*/

class Solution {
    public int gethours(int mid, int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += Math.ceil((double) arr[i] / mid);
        }
        return count;
    }

    public int min(int[] arr, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            high = Math.max(high, arr[i]);
        }

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int hours = gethours(mid, arr);

            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }

        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        return min(piles, h);
    }
}
 
