class Solution {
    public String toposort(ArrayList<ArrayList<Integer>> adj, int K) {
        int[] indegree = new int[K];
        Arrays.fill(indegree, 0);
        
        // Calculate indegree of each node
        for (int i = 0; i < K; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        // Add nodes with zero indegree to the queue
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Perform BFS and construct the topological order
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append((char) (node + 'a'));
            
            for (Integer n : adj.get(node)) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    queue.add(n);
                }
            }
        }
        
        // If we didn't process all nodes, return an empty string
        if (sb.length() != K) {
            return "";
        }
        
        return sb.toString();
    }
    
    public String findOrder(String[] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        // Build the adjacency list
        for (int i = 0; i < N - 1; i++) {
            String a = dict[i];
            String b = dict[i + 1];
            
            int minLength = Math.min(a.length(), b.length());
            boolean foundDifference = false;
            
            for (int j = 0; j < minLength; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    adj.get(a.charAt(j) - 'a').add(b.charAt(j) - 'a');
                    foundDifference = true;
                    break;
                }
            }
            
            // Case where b is a prefix of a but longer
            if (!foundDifference && a.length() > b.length()) {
                return "";
            }
        }
        
        return toposort(adj, K);
    }
}
