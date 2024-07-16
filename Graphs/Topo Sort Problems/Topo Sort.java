


class Solution
{
    
    static void  dfs(int V,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,int node,boolean[] vis)
    {
        vis[node]=true;
        for(Integer it : adj.get(node))
        {
            if(!vis[it])
            {
                dfs(V,adj,st,it,vis);
            }
        }
        st.add(node);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int i;
        int[] res=new int[V];
        boolean[] vis=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(i=0;i<V;i++)
        {
            vis[i]=false;
        }
        for( i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs(V,adj,st,i,vis);
            }
        }
        i=0;
        while(!st.isEmpty())
        {
            res[i]=st.pop();
            i++;
        }
        return res;
        
    }
}
