/*
You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n
nodes to receive the signal, return -1.
*/

class Pair {
    int v, wt;

    Pair(int v, int wt) {
        this.v = v;
        this.wt = wt;
    }
}

class Solution {
    public int dijktras(List<List<Pair>> graph, int n, int k) {
        boolean[] vis = new boolean[n + 1];
        Arrays.fill(vis, false);
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        q.add(new Pair(k, 0));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int u = curr.v;
            int wt = curr.wt;
            for (Pair temp : graph.get(u)) {
                if (wt + temp.wt < dist[temp.v]) {
                    dist[temp.v] = wt + temp.wt;
                    q.add(new Pair(temp.v, dist[temp.v]));
                }
            }
        }
        int maxi = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxi = Math.max(maxi, dist[i]);
        }
        return maxi;

    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Pair>());

        }
        for (int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        return dijktras(graph, n, k);
    }
}
 
