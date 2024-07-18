// time complexity O(E-- Edges)
// time complexity O(N + E) 
// Overall time complexity O(N+2E)
class pair
{
    int node;
    int wt;
    pair(){}
    pair(int node,int wt)
    {
        this.node=node;
        this.wt=wt;
    }
}
// /User function Template for Java

class Solution {
    public void toposortDFS(ArrayList<ArrayList<pair>> adj,int node,boolean[] vis,Stack<Integer> st)
    {
        vis[node]=true;
        
        for(pair temp: adj.get(node))
        {
            if(!vis[temp.node])
            {
                toposortDFS(adj,temp.node,vis,st);
            }
        }
        st.add(node);
        
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int i;
		ArrayList<ArrayList<pair>> adj=new ArrayList<>();
		for(i=0;i<N;i++)
		{
		    adj.add(new ArrayList<pair>());
		}
		for( i=0;i<edges.length;i++)
		{
		    adj.get(edges[i][0]).add(new pair(edges[i][1],edges[i][2]));
		}
		boolean[] vis=new boolean[N];
		int[] dist=new int[N];
		for(i=0;i<N;i++)
		{
		    vis[i]=false;
		    dist[i]=Integer.MAX_VALUE;
		}
		Stack<Integer> st=new Stack<>();
    // time complexity O(E-- Edges)
		toposortDFS(adj,0,vis,st);
		
		dist[0]=0;
    // time complexity O(N + E) 
    // Overall time complexity O(N+2E)
		while(!st.isEmpty())
		{
		    int u=st.pop();
		    for(pair temp: adj.get(u))
		    {
		        int v=temp.node;
		        int wt=temp.wt;
		        if(dist[u]+wt<dist[v])
		        {
		            dist[v]=dist[u]+wt;
		        }
		    }
		}
		for(i=0;i<N;i++)
		{
		    if(dist[i]==Integer.MAX_VALUE)
		    {
		        dist[i]=-1;
		        
		    }
		}
		return dist;
		
	}
}
