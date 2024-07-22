// Minimum spanning trees using   PRIME'S ALGORITHM


// User function Template for Java
class Pair
{
    int wt,node,parent;
    Pair(int wt,int node,int parent)
    {
        this.wt=wt;
        this.node=node;
        this.parent=parent;
    }
    
}
class Solution {
    static int findminsum(int V,int E,List<List<int[]>> adj)
    {
        int i;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.wt -y.wt);
        boolean[] visited=new boolean[V];
        pq.add(new Pair(0,0,-1));
        // visited[0]=true;
        int sum=0;
        while(!pq.isEmpty())
        {
            Pair temp=pq.poll();
            
            int node=temp.node;
            int parent=temp.parent;
            // System.out.println(temp.wt + " "+ node + " "+ parent);
            
            if(visited[node]==false)
            {
                sum+=temp.wt;    
                visited[node]=true;
                for(i=0;i<adj.get(node).size();i++)
                {
                    int nextnode=adj.get(node).get(i)[0];
                    int cost=adj.get(node).get(i)[1];
                    pq.add(new Pair(cost,nextnode,node));
                    // System.out.println(cost+ " " +nextnode+" "+node);
                }
            }
            
        }
        return sum;
        
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        return findminsum(V,E,adj);
    }
}
