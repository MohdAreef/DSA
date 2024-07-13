class Solution {

    boolean checkBipartite(int[][] graph, int[] colors, int start, int c) {
        int i;
        colors[start] = c;
        for (i = 0; i < graph[start].length; i++) {
            int a = graph[start][i];
            if (colors[start] == colors[a]) {
                return false;
            }
            if (colors[a] == -1) {
                if (!checkBipartite(graph, colors, a, 1 - colors[start])) {
                    return false;
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
            if (colors[i] == -1 && !checkBipartite(graph, colors, i, 0)) {
                return false;
            }
        }
        return true;
    }
}
