/*
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.
*/

class Solution {

    public int getMaxIndex(int[][] arr, int mid) {
        int maxi = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][mid] > maxi) {
                maxi = arr[i][mid];
                index = i;
            }
        }
        return index;
    }

    public int[] find(int[][] mat) {
        int low = 0, high = mat[0].length - 1;

        int cols = mat[0].length;

        while (low <= high) {
            int mid = (low + high) / 2;

            int row = getMaxIndex(mat, mid);

            // System.out.println(low+" "+high+"max"+row);

            if (mid + 1 < cols && mid - 1 >= 0 && mat[row][mid] > mat[row][mid + 1]
                    && mat[row][mid] > mat[row][mid - 1]) {
                return new int[] { row, mid };
            }

            else if (mid + 1 >= cols && mid - 1 >= 0 && mat[row][mid] > mat[row][mid - 1]) {
                return new int[] { row, mid };
            }

            else if (mid - 1 <= 0 && mid + 1 < cols && mat[row][mid] > mat[row][mid + 1])
                return new int[] { row, mid };

            else if (mid - 1 >= 0 && mat[row][mid - 1] > mat[row][mid]) {
                high = mid - 1;
            }

            else {
                low = mid + 1;
            }

        }

        return new int[] { 0, 0 };
    }

    public int[] findPeakGrid(int[][] mat) {
        return find(mat);
    }
}
