// Dijkstra's algorithm using Priority Queue

class Pair
{
    int wt,node;
    Pair(int wt,int node)
    {
        this.wt=wt;
        this.node=node;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijk(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int S)
    {
        int i;
        int[] dist=new int[V];
        
        for(i=0;i<V;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y) -> x.wt-y.wt);
        pq.add(new Pair(0,S));
        dist[S]=0;
        
        while(!pq.isEmpty())
        {
            Pair temp=pq.poll();
            
            int wt=temp.wt;
            int node=temp.node;
            for(i=0;i<adj.get(node).size();i++)
            {
                int weight=adj.get(node).get(i).get(1);
                int adjnode=adj.get(node).get(i).get(0);
                
                if(wt+weight<dist[adjnode])
                {
                    dist[adjnode]=wt+weight;
                    pq.add(new Pair(dist[adjnode],adjnode));
                }
            }
        }
        return dist;
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        return dijk(V,adj,S);
    }
}

