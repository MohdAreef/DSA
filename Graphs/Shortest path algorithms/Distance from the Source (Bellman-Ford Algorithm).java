/*
Given a weighted and directed graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S. 
If a vertices can't be reach from the S then mark the distance as 10^8. Note: If the Graph contains a negative cycle then return an array consisting 
of only -1.

*/




/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    
    static int[] bellman(int V,ArrayList<ArrayList<Integer>> edges,int S)
    {
        int i,j;
        int[] dist=new int[V];
        for(i=0;i<V;i++)
        {
            dist[i]= 100000000;
        }
        dist[S]=0;
        
        for(i=0;i<V-1;i++)
        {
          for(j=0;j<edges.size();j++)
          {
              int u=edges.get(j).get(0);
              int v=edges.get(j).get(1);
              int cost=edges.get(j).get(2);
            //   System.out.println(u+" "+cost+" "+v);
              if(dist[u] != 100000000 && dist[u]+cost<dist[v])
              {
                  dist[v]=dist[u]+cost;
              }
          }
        }
        
        
        
        for(j=0;j<edges.size();j++)
          {
              int u=edges.get(j).get(0);
              int v=edges.get(j).get(1);
              int cost=edges.get(j).get(2);
            //   System.out.println(u+" "+cost+" "+v);
              if( dist[u] != 100000000 && dist[u]+cost<dist[v])
              {
                  return new int[]{-1};
              }
          }
        
        
     
        return dist;
        
    }
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        return bellman(V,edges,S);
    }
}
