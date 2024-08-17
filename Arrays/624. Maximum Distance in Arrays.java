/*
you are given m arrays, where each array is sorted in ascending order.

You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers 
a and b to be their absolute difference |a - b|.

Return the maximum distance.

Example 1:

Input: arrays = [[1,2,3],[4,5],[1,2,3]]
Output: 4
Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
*/

class Solution {

    public int maxDist(List<List<Integer>> res) {

        int n = res.size();
        int maxdistance = 0;
        int min = res.get(0).get(0);
        int max = res.get(0).get(res.get(0).size() - 1);

        for (int i = 1; i < n; i++) {
            int currmin = res.get(i).get(0);
            int currmax = res.get(i).get(res.get(i).size() - 1);

            int size = res.get(i).size();
            maxdistance = Math.max(maxdistance, Math.abs(min - currmax));
            maxdistance = Math.max(maxdistance, Math.abs(max - currmin));

            if (currmin < min)
                min = currmin;

            if (currmax > max)
                max = currmax;
        }

        return maxdistance;
    }

    public int maxDistance(List<List<Integer>> arrays) {

        return maxDist(arrays);

    }
}
