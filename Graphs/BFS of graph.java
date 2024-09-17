/*
Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph starting from the 0th vertex, 
from left to right according to the input graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.
*/

class Solution {
    // Function to return Breadth First Traversal of given graph.
     public ArrayList<Integer> bfs(int V,ArrayList<ArrayList<Integer>> adj)
     {
         ArrayList<Integer> path=new ArrayList<>();
         boolean[] vis=new boolean[V];
         Arrays.fill(vis,false);
         Queue<Integer> q=new LinkedList<>();
         q.add(0);
         vis[0]=true;
         path.add(0);
         while(!q.isEmpty())
         {
             int node=q.poll();
             
             for(int v: adj.get(node))
             {
                 if(vis[v]==false)
                 {
                     path.add(v);
                     vis[v]=true;
                     q.add(v);
                 }
             }
         }
         return path;
         
     }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        return bfs(V,adj);
    }
}
