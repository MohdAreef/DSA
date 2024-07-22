// it can be solved with DFS or BFS traversal techniques
// in this problem is has been solved with Disjointset data structur

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
    public int findCircleNum(int[][] isConnected) {
        int i, j;
        int n = isConnected.length;

        Disjointset ds = new Disjointset(n);
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionBySize(i, j);

                }
            }
        }
        // to count the Ultimate parents 
        // count for the one who have themself as parent 
        int cnt = 0;
        for (i = 0; i < n; i++) {
            if (ds.findUparent(i) == i) {
                cnt++;
            }
        }
        return cnt;
    }
}
