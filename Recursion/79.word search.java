/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
  
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
*/
class Solution {
    public boolean pathexists(int index, int r, int c, boolean[][] vis, int m, int n, char[][] board, String word) {
        // base conditions
        if (index == word.length()) {
            return true;
        }
        

        // explore
        int i;
        int[] rows = { 0, 1, 0, -1 };
        int[] cols = { -1, 0, 1, 0 };

        for (i = 0; i < 4; i++) {
            int newrow = r + rows[i];
            int newcol = c + cols[i];
            if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n && vis[newrow][newcol] == false
                    && board[newrow][newcol] == word.charAt(index)) {
                vis[newrow][newcol] = true;
                if (pathexists(index + 1, newrow, newcol, vis, m, n, board, word) == true) {
                    return true;
                }

                vis[newrow][newcol] = false;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {

        int i, j;
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (boolean[] b : vis) {
            Arrays.fill(b, false);
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {
                    vis[i][j] = true;
                    if (pathexists(1, i, j, vis, m, n, board, word) == true) {
                        return true;
                    }

                    vis[i][j] = false;
                }
            }
        }
        return false;
    }
}
