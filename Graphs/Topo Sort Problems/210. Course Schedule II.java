//IT SAME AS COURSE SCHEDULE PROBLEM 1 BUT IN THIS PROLEM WE NEED TO RETURN THE POSSIBLE PATH IF NOT EXISTS THEN RETURN EMPTY ARRAY
// USE TOPO SORT WITH INDEGREE CONCEPT TO GET THE ONE OF THE POSSIBLE ANSWERS(IN THIS CASE PATH/COURSES)

class Solution {
    public int[] toposortpossible(int V, ArrayList<ArrayList<Integer>> adj) {
        int i;
        // add your code here
        int indegree[] = new int[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (i = 0; i < V; i++) {
            indegree[i] = 0;
        }
        for (i = 0; i < V; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }

        int[] ans = new int[V];
        for (i = 0; i < V; i++) {
            ans[i] = -1;
        }
        int j = 0;
        for (i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                ans[j++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                    ans[j++] = it;
                }
            }
        }
        for (i = 0; i < V; i++) {
            if (ans[i] == -1) {
                return new int[0];
            }
        }
        return ans;

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

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

        return toposortpossible(numCourses, adj);

    }
}
