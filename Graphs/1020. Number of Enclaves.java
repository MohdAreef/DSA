class Pair {
    int i, j;

    Pair() {
    };

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

class Solution {

    public int bfs(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        int i, j;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                vis[i][j] = false;
            }
        }
        for (j = 0; j < n; j++) {
            if (grid[0][j] == 1 && vis[0][j] == false) {
                vis[0][j] = true;
                q.add(new Pair(0, j));
            }
            if (grid[m - 1][j] == 1 && vis[m - 1][j] == false) {
                vis[m - 1][j] = true;
                q.add(new Pair(m - 1, j));
            }
        }
        for (i = 0; i < m; i++) {
            if (grid[i][0] == 1 && vis[i][0] == false) {
                vis[i][0] = true;
                q.add(new Pair(i, 0));
            }

            if (grid[i][n - 1] == 1 && vis[i][n - 1] == false) {
                vis[i][n - 1] = true;
                q.add(new Pair(i, n - 1));
            }
        }

        int rows[] = { 0, 1, 0, -1 };
        int cols[] = { -1, 0, 1, 0 };

        while (q.isEmpty() == false) {
            Pair temp = q.poll();

            for (int k = 0; k < 4; k++) {

                int newrow = temp.i + rows[k];
                int newcol = temp.j + cols[k];
                if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n) {
                    if (grid[newrow][newcol] == 1 && vis[newrow][newcol] == false) {
                        vis[newrow][newcol] = true;
                        q.add(new Pair(newrow, newcol));
                    }
                }

            }
        }

        int cnt = 0;
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int numEnclaves(int[][] grid) {
        return bfs(grid);
    }
}
