// Fiding eventual safe state 
// terminal node = node with no outgoing edges are called terminal nodes
  // safe node= all the outgoing paths from a particular  node leads to a terminal node then this particular node is said to be safe node 
// find the safe node in given directed graph
// reverse the edges and apply topo sort algorithm

class Solution {
    public List<Integer> toposort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int indegree[] = new int[V];
        int i;
        for (i = 0; i < V; i++) {
            indegree[i] = 0;
        }
        for (i = 0; i < V; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                res.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    res.add(it);
                    queue.add(it);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int i, j;
        for (i = 0; i < graph.length; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            adj.add(temp);
        }
        for (i = 0; i < graph.length; i++) {
            for (j = 0; j < graph[i].length; j++) {
                // adj.get(i).add(graph[i][j]);
                // reverse the edges
                adj.get(graph[i][j]).add(i);
            }
        }

        return toposort(adj);

    }
}
