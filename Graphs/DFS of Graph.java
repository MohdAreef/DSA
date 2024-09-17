/*
You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use the recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.
*/
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    ArrayList<Integer> path=new ArrayList<>();
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis)
    {
     vis[node]=true;
     path.add(node);
     
     for(int v:adj.get(node))
     {
         if(vis[v]==false)
         {
             dfs(v,adj,vis);
         }
     }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[V];
        Arrays.fill(vis,false);
        dfs(0,adj,vis);
        return path;
    }
}
