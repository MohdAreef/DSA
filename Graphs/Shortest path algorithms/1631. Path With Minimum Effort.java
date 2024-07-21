/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the 
height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) 
(i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
  */

class Pair {
    int diff, i, j;

    Pair(int diff, int i, int j) {
        this.diff = diff;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int minimum(int[][] grid) {
        int i, j;
        int r = grid.length;
        int c = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.diff - y.diff);
        int[][] dist = new int[r][c];
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        int[] rows = { 0, 1, 0, -1 };
        int[] cols = { -1, 0, 1, 0 };

        pq.add(new Pair(0, 0, 0));
        dist[0][0] = 0;
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int currrow = temp.i;
            int currcol = temp.j;

            if (currrow == (r - 1) && currcol == (c - 1)) {
                ans = Math.min(ans, temp.diff);
            }

            for (i = 0; i < 4; i++) {
                int nextrow = currrow + rows[i];
                int nextcol = currcol + cols[i];

                if (nextrow >= 0 && nextrow < r && nextcol >= 0 && nextcol < c) {
                    int difference = Math.max(temp.diff, Math.abs(grid[currrow][currcol] - grid[nextrow][nextcol]));
                    if (difference < dist[nextrow][nextcol]) {
                        dist[nextrow][nextcol] = difference;
                        pq.add(new Pair(difference, nextrow, nextcol));
                    }
                }
            }

        }
        return ans;

    }

    public int minimumEffortPath(int[][] heights) {
        return minimum(heights);
    }
}
