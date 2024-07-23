/* 
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents 
a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between 
any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
*/
//above problem has dynamic configuration of the graph so we can use Disjointset Data Structure


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

    public int unionBySize(int u, int v) {
        int uparent_u = findUparent(u);
        int uparent_v = findUparent(v);

        if (uparent_u == uparent_v) {
            return 1;
        }

        else if (size.get(uparent_u) < size.get(uparent_v)) {
            parent.set(uparent_u, uparent_v);
            size.set(uparent_v, size.get(uparent_u) + size.get(uparent_v));
        }

        else {
            parent.set(uparent_v, uparent_u);
            size.set(uparent_u, size.get(uparent_u) + size.get(uparent_v));
        }
        return 0;

    }
}

class Solution {

    public int noOfEdges(int n, int[][] connections) {
        int i, extra = 0, noOfComponents = 0;
        Disjointset ds = new Disjointset(n);
        for (i = 0; i < connections.length; i++) {
            if (ds.unionBySize(connections[i][0], connections[i][1]) == 1) {
                extra += 1;
            }
        }

        for (i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                noOfComponents += 1;
            }
        }

        if (extra >= (noOfComponents - 1)) {
            return noOfComponents - 1;
        }
        return -1;

    }

    public int makeConnected(int n, int[][] connections) {

        return noOfEdges(n, connections);

    }
}
