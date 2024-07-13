class Solution {

    boolean checkBipartite(int[][] graph, int[] colors, int start) {
        int m = graph.length;
        int i;

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        colors[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (i = 0; i < graph[node].length; i++) {
                int a = graph[node][i];
                if (colors[a] == colors[node]) {
                    return false;
                } else {
                    if (colors[a] == -1) {
                        colors[a] = colors[node] == 0 ? 1 : 0;
                        q.add(a);
                    }
                }
            }
        }
        return true;

    }

    public boolean isBipartite(int[][] graph) {

        int m = graph.length;
        int i;
        int colors[] = new int[m];
        for (i = 0; i < m; i++) {
            colors[i] = -1;
        }

        for (i = 0; i < m; i++) {
            if (colors[i] == -1 && !checkBipartite(graph, colors, i)) {
                return false;
            }
        }
        return true;

    }
}
