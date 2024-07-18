
class Solution
{
    
    public String toposort(ArrayList<ArrayList<Integer>> adj,int N,int K)
    {
        int i;
        int[] indegree=new int[K];
        for(i=0;i<K;i++)
        {
            indegree[i]=0;
        }
        for(i=0;i<K;i++)
        {
        for(Integer it: adj.get(i))
        {
            indegree[it]++;
        }
        }
        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(i=0;i<K;i++)
        {
            if(indegree[i]==0)
            {
                list.add(i);
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(Integer n:adj.get(node))
            {
                indegree[n]--;
                if(indegree[n]==0)
                {
                    queue.add(n);
                    list.add(n);
                }
            }
        }
        // ArrayList<Character> temp=new ArrayList<>();
        // for(Integer m:list)
        // {
        //     temp.add((char)(m+'a'));
        // }
        // String res=temp.toString(); 
        // System.out.println(res);
        // return res;
        
        StringBuilder sb = new StringBuilder();
        for (Integer c : list) {
            sb.append((char)(c+'a'));
        }
        
        return sb.toString();
        
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        int i,j;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(i=0;i<K;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        
        for(i=0;i<N-1;i++)
        {
            String a=dict[i];
            String b=dict[i+1];
            for(j=0;j<a.length() && j<b.length();j++)
            {
                if(a.charAt(j)<b.charAt(j))
                {
                    adj.get((int)(a.charAt(j)-'a')).add((int)(b.charAt(j)-'a'));
                    break;
                }
                if(a.charAt(j)>b.charAt(j))
                {
                    adj.get(a.charAt(j)-'a').add(b.charAt(j)-'a');
                    break;
                }
            }
        }
        
        return toposort(adj,N,K);
        
        
    }
}
