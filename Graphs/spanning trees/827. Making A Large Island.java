/* You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s. */

 
/*
Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
*/

// since in this problem  componets changes dynamically when we replace 0's with 1 so we can go with Disjoint Set DATA STRUCTURE

class Disjointset {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    Disjointset(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUparent(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        int uparent = findUparent(parent.get(node));
        parent.set(node, uparent);
        return uparent;
    }

    public void unionBySize(int u, int v) {
        int uparent_u = findUparent(u);
        int uparent_v = findUparent(v);

        if (uparent_u == uparent_v) {
            return;
        }

        else if (size.get(uparent_u) < size.get(uparent_v)) {
            parent.set(uparent_u, uparent_v);
            size.set(uparent_v, size.get(uparent_u) + size.get(uparent_v));
        }

        else {
            parent.set(uparent_v, uparent_u);
            size.set(uparent_u, size.get(uparent_u) + size.get(uparent_v));
        }

    }
}

class Solution {

    public int largestIsland(int[][] grid) {
        int i, j, k, newrow, newcol;
        int n = grid.length;
        int[] rows = { 0, 1, 0, -1 };
        int[] cols = { -1, 0, 1, 0 };

        Disjointset ds = new Disjointset(n * n);

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (k = 0; k < 4; k++) {
                        newrow = i + rows[k];
                        newcol = j + cols[k];

                        if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < n && grid[newrow][newcol] == 1) {
                            int currentnode = i * n + j;
                            int nextnode = newrow * n + newcol;

                            ds.unionBySize(currentnode, nextnode);
                        }
                    }
                }
            }
        }

        int maxsize = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {
            maxsize = Math.max(maxsize, ds.size.get(i));
        }
        // System.out.println(ds.size.get(ds.findUparent(0)));

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    int count = 1;
                    for (k = 0; k < 4; k++) {
                        newrow = i + rows[k];
                        newcol = j + cols[k];
                        if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < n && grid[newrow][newcol] == 1) {
                            int node = newrow * n + newcol;
                            int ultimateparent = ds.findUparent(node);
                            if (!set.contains(ultimateparent)) {
                                count = count + ds.size.get(ultimateparent);
                                set.add(ultimateparent);
                            }
                        }
                    }
                    maxsize = Math.max(maxsize, count);
                }
            }
        }
        return maxsize;

    }
}
