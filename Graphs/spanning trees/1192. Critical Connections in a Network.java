// Finding the Bridges in a graph
/*
There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] 
represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.
*/

class Solution {
    public int timer = 0;

    public void dfs(int node, int parent, List<List<Integer>> connections, boolean[] vis, List<List<Integer>> res,
            int[] time, int[] lowest) {
        vis[node] = true;

        time[node] = timer;
        lowest[node] = timer;
        timer++;

        for (Integer it : connections.get(node)) {
            if (it == parent) {
                continue;
            }
            if (!vis[it]) {
                dfs(it, node, connections, vis, res, time, lowest);
                lowest[node] = Math.min(lowest[node], lowest[it]);
            } else {
                lowest[node] = Math.min(lowest[node], lowest[it]);
            }

            if (time[node] < lowest[it]) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(it);
                temp.add(node);
                res.add(temp);
            }

        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        int i;
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int[] time = new int[n];
        int[] lowest = new int[n];
        for (i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, i, graph, vis, res, time, lowest);
            }
        }

        return res;

    }
}
