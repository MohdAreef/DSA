/*
Given a binary tree and a node data called target. Find the minimum time required to burn the complete binary tree if the target is set on fire. It is known that in 1 second all nodes 
connected to a given node get burned. That is its left child, right child, and parent.
Note: The tree contains unique values.

Examples : 

Input:      
          1
        /   \
      2      3
    /  \      \
   4    5      6
       / \      \
      7   8      9
                   \
                   10
Target Node = 8
Output: 7
Explanation: If leaf with the value 8 is set on fire. 
After 1 sec: 5 is set on fire.
After 2 sec: 2, 7 are set to fire.
After 3 sec: 4, 1 are set to fire.
After 4 sec: 3 is set to fire.
After 5 sec: 6 is set to fire.
After 6 sec: 9 is set to fire.
After 7 sec: 10 is set to fire.
It takes 7s to burn the complete tree.
*/


class Pair
{
    int time;
    Node node;
    Pair(int time,Node node)
    {
        this.time=time;
        this.node=node;
    }
}
class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    public static Node gettarget(Node node,int target)
    {
        if(node==null) return node;
        if(node.data==target) return node;
        
        //explore
        Node left=gettarget(node.left,target);
        if(left!=null)
        {
            return left;
        }
        Node right=gettarget(node.right,target);
        if(right!=null)
        {
            return right;
        }
        return null;
    }
    public static int maxvalue(Node node)
    {
        if(node==null) return (int)-1e9;
        
        
        int left=maxvalue(node.left);
        int right=maxvalue(node.right);
        
        return Math.max(left,Math.max(right,node.data));
    }
    public static void getparent(Node node,Node parent,HashMap<Integer,Node> map)
    {
      if(node==null) return ;
      
      //explore
      map.put(node.data,parent);
      getparent(node.left,node,map);
      getparent(node.right,node,map);
       
    }
    
    public static int burntime(Node root,Node target,HashMap<Integer,Node> map)
    {
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(0,target));
        int maximumvalue=maxvalue(root);
        // System.out.println("maximum value"+maximumvalue);
        boolean[] vis=new boolean[maximumvalue+1];
        Arrays.fill(vis,false);
        vis[target.data]=true;
        int maxtime=0;
        while(!queue.isEmpty())
        {
            // System.out.println("inside queue");
            Pair temp=queue.poll();
            Node curr=temp.node;
            int time=temp.time;
            maxtime=Math.max(maxtime,time);
            
            
            if(curr.left!=null && !vis[curr.left.data])
            {
                vis[curr.left.data]=true;
                queue.add(new Pair(time+1,curr.left));
            }
            if(curr.right!=null && !vis[curr.right.data])
            {
                vis[curr.right.data]=true;
                queue.add(new Pair(time+1,curr.right));
            }
            if(map.get(curr.data)!=null && !vis[map.get(curr.data).data])
            {
                
                vis[map.get(curr.data).data]=true;
                queue.add(new Pair(time+1,map.get(curr.data)));
            }
        }
        
        return maxtime;
        
        
        
        
    }
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        Node targetnode=gettarget(root,target);
        // System.out.println("target value"+ targetnode.data);
        
        // int maximum=maxvalue(root);
        
        HashMap<Integer,Node> map=new HashMap<>();
        getparent(root,null,map);
        
        // System.out.println(map.get(8).data);
        
        return burntime(root,targetnode,map);
        
    }
}
