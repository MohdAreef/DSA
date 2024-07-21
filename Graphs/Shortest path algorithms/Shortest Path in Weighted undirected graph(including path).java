// we need to return the not only minimum distance but also shortest path 
/* 
You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges along with their weights. Find the shortest path between the vertex 1 and the vertex n,  
if there exists a path, and return a list of integers whose first element is the weight of the path, and the rest consist of the nodes on that path. If no path exists, then return 
a list containing a single element -1.

The input list of edges is as follows - {a, b, w}, denoting there is an edge between a and b, and w is the weight of that edge.

Note: The driver code here will first check if the weight of the path returned is equal to the sum of the weights along the nodes on that path, if equal it will output the 
weight of the path, else -2. In case the list contains only a single element (-1) it will simply output -1.   

*/

class Pair
{
    int wt,node;
    Pair(int node,int wt)
    {
        this.node=node;
        this.wt=wt;
    }
}
class Solution {
    public List<Integer> findpath(int n,int m ,ArrayList<ArrayList<Pair>> adj)
    {
        int i;
        int[] parent=new int[n+1];
        for(i=1;i<n+1;i++)
        {
            parent[i]=i;
        }
        int[] dist=new int[n+1];
        for(i=1;i<n+1;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.wt-y.wt);
        
        pq.add(new Pair(1,0));
        dist[1]=0;
        
        while(!pq.isEmpty())
        {
            Pair temp=pq.poll();
            for(i=0;i<adj.get(temp.node).size();i++)
            {
                Pair adjtemp=adj.get(temp.node).get(i);
                
                int adjnode=adjtemp.node;
                int wt=adjtemp.wt;
                
                if(temp.wt+wt < dist[adjnode])
                {
                    parent[adjnode]=temp.node;
                    dist[adjnode]=temp.wt+wt;
                    pq.add(new Pair(adjnode,dist[adjnode]));
                }
                
            }
        }
        
     
        
        ArrayList<Integer> res=new ArrayList<>();
        
        if(dist[n]==Integer.MAX_VALUE)
        {
            res.add(-1);
            return res;
        }
        
        
      
      
        int node=n;
        res.add(node);
        while(node!=parent[node])
        {
            res.add(parent[node]);
            node=parent[node];
        }
        
        // res.add(node);
          res.add(dist[n]);
         Collections.reverse(res);
        // for(Integer it:res)
        // {
        //     System.out.println(it+" ");
        // }
        // System.out.println("over");
        //   res.add(dist[n]);
        return res;
        
        
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        
         int i,j;
      ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
      for(i=0;i<n+1;i++)
      {
          adj.add(new ArrayList<Pair>());
         
      }
      
      for(i=0;i<m;i++)
      {
          adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
          adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
          
      }
      
      return findpath(n,m,adj);
      
      
    }
}
