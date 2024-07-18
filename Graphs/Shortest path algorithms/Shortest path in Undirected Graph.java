// using Queue data structure
class pair
{
    int u,cost;
    pair(int u,int v)
    {
        this.u=u;
        this.cost=v;
    }
}
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int i=0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dist=new int[n];
        for(i=0;i<n;i++)
        {
            dist[i]=Integer.MAX_VALUE;
            
        }
        dist[src]=0;
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(src,0));
        
        while(!queue.isEmpty())
        {
            pair temp=queue.poll();
            int u=temp.u;
            int cost=temp.cost;
            
            for(Integer v:adj.get(u))
            {
                if(cost+1<dist[v])
                {
                    dist[v]=cost+1;
                    queue.add(new pair(v,dist[v]));
                }
            }
        }
        for(i=0;i<n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            {
                dist[i]=-1;
            }
        }
        return dist;
    }
}
