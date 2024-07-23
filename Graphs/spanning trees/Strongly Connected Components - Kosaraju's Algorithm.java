// to find the STRONGLY CONNECTED COMPONENTS
// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.

class Solution
{
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean[] vis)
    {
        vis[node]=true;
        for(Integer it: adj.get(node))
        {
            if(!vis[it])
            {
                dfs(it,adj,st,vis);
            }
        }
        st.add(node);
        
    }
    public int findSCC(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int i,j;
        Stack<Integer> stack=new Stack<Integer>();
        boolean[] vis=new boolean[V];
        Arrays.fill(vis,false);
        for(i=0;i<V;i++)
        {
            if(!vis[i])
            {
                        
                dfs(i,adj,stack,vis);
            }
        }
        
        ArrayList<ArrayList<Integer>> newadj=new ArrayList<>();
        for(i=0;i<adj.size();i++)
        {
            newadj.add(new ArrayList<Integer>());
        }
        
        for(i=0;i<adj.size();i++)
        {
            for(j=0;j<adj.get(i).size();j++)
            {
                int u=i;
                int v=adj.get(i).get(j);
                newadj.get(v).add(u);
            }
        }
        int cnt=0;
        Arrays.fill(vis,false);
        while(!stack.isEmpty())
        {
            i=stack.pop();
            if(!vis[i])
            {
                dfs(i,newadj,stack,vis);
                cnt++;
            }
        }
        return cnt;
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        return findSCC(V,adj);
    }
}
