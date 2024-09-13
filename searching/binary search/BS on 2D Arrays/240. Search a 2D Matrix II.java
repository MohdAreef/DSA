/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*/


class Solution {
    public boolean search(int[][] mat, int target) {
        int rows = mat.length;
        int i = 0;
        int j = mat[0].length - 1;
        while (i < rows && j >= 0) {
            if (mat[i][j] == target)
                return true;

            else if (mat[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        return search(matrix, target);

    }
}
