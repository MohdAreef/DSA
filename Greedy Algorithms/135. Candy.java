/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
*/


class Solution {
    public int assign(int[] arr) {
        int n = arr.length;
        int[] mincandies = new int[n];

        Arrays.fill(mincandies, 1); // initially assign 1 candy to each

        mincandies[0] = 1;
        for (int i = 1; i < n; i++) // assign candies based on neighbors
        {
            mincandies[i] = 1;
            if (arr[i] > arr[i - 1]) {
                mincandies[i] = mincandies[i - 1] + 1;
            }
            if (i + 1 < n && arr[i] > arr[i + 1]) {
                mincandies[i] = mincandies[i + 1] + 1;
            }
        }

        // System.out.println(Arrays.toString(mincandies));

        int sum = 0;
        for (int i = n - 1; i >= 0; i--) // assign candies based on neighbors
        {
            if (i + 1 < n && arr[i] > arr[i + 1]) {
                mincandies[i] = mincandies[i + 1] + 1;
            }
            if (i - 1 >= 0 && arr[i] > arr[i - 1]) {
                mincandies[i] = Math.max(mincandies[i], mincandies[i - 1] + 1);
            }
            sum += mincandies[i];
        }
        return sum;

    }

    public int candy(int[] ratings) {
        return assign(ratings);
    }
}
