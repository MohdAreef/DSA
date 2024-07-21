/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there 
is a flight from city fromi to city toi with cost pricei.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
  */

class Pair {
    int node, cost;

    Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Group {
    int step, node, cost;

    Group(int step, int node, int cost) {
        this.step = step;
        this.node = node;
        this.cost = cost;
    }
}

class Solution {
    public int findpath(int n, ArrayList<ArrayList<Pair>> adj, int src, int dst, int k) {
        Queue<Group> queue = new LinkedList<>();
        int i;
        int[] dist = new int[n];
        for (i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;

        }
        queue.add(new Group(0, src, 0));
        dist[src] = 0;
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Group temp = queue.poll();
            int step = temp.step;
            int node = temp.node;
            int cost = temp.cost;

            if (node == dst) {
                ans = Math.min(ans, cost);
                continue;
            }

            if (step > (k)) {
                continue;
            }
            
            for (Pair adjnode : adj.get(node)) {
                if (cost + adjnode.cost < dist[adjnode.node]) {
                    dist[adjnode.node] = cost + adjnode.cost;
                    queue.add(new Group(step + 1, adjnode.node, dist[adjnode.node]));
                }
            }

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int i;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        return findpath(n, adj, src, dst, k);

    }
}
