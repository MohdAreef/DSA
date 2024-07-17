course schedule 1 problem
// it as same as detecting cycle in directed graph using dfs algorithm
// using visited and pathvisited to detect the cycle
class Solution {
    public boolean dfs(int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] pathvis, int node) {
        vis[node] = true;
        pathvis[node] = true;
        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                if (dfs(V, adj, vis, pathvis, it) == false) {
                    return false;
                }
            } else {
                if (pathvis[it] == true) {
                    return false;
                }
            }
        }
        pathvis[node] = false;
        return true;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int i, j;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (i = 0; i < numCourses; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            adj.add(temp);
        }
        for (i = 0; i < prerequisites.length; i++) {

            for (j = prerequisites[i].length - 1; j > 0; j--) {
                adj.get(prerequisites[i][j]).add(prerequisites[i][j - 1]);
            }
        }
        for (i = 0; i < numCourses; i++) {
            for (Integer it : adj.get(i)) {
                System.out.println(i + " " + it);
            }

        }
        boolean[] vis = new boolean[numCourses];
        boolean[] pathvis = new boolean[numCourses];
        for (i = 0; i < numCourses; i++) {
            vis[i] = false;
            pathvis[i] = false;
        }
        for (i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (!dfs(numCourses, adj, vis, pathvis, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
