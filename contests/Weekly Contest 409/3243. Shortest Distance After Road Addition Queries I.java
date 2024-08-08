/* 
You are given an integer n and a 2D integer array queries.
There are n cities numbered from 0 to n - 1. Initially, there is a unidirectional road from city i to city i + 1 for all 0 <= i < n - 1.
queries[i] = [ui, vi] represents the addition of a new unidirectional road from city ui to city vi. After each query, you need to find the length of the shortest path from city 0 to city n - 1.
Return an array answer where for each i in the range [0, queries.length - 1], answer[i] is the length of the shortest path from city 0 to city n - 1 after processing the first i + 1 queries.
 
Example 1:

Input: n = 5, queries = [[2,4],[0,2],[0,4]]

Output: [3,2,1]
*/

class Pair {
    int u, cost;

    Pair(int u, int cost) {
        this.u = u;
        this.cost = cost;
    }
}

class Solution {
    public int dijkstras(int n, List<List<Integer>> graph) {
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> queue = new LinkedList<>();
        dist[0] = 0;
        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            int u = temp.u;
            int cost = temp.cost;
            for (Integer v : graph.get(u)) {
                if (cost + 1 < dist[v]) {
                    dist[v] = cost + 1;
                    queue.add(new Pair(v, dist[v]));
                }
            }
        }
        return dist[n - 1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        int i;
        for (i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }

        int[] result = new int[queries.length];
        for (i = 0; i < queries.length; i++) {
            graph.get(queries[i][0]).add(queries[i][1]);
            int mindist = dijkstras(n, graph);
            result[i] = mindist;

        }

        return result;

    }
}
