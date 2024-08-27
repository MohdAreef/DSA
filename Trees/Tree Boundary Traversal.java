/*
Difficulty: MediumAccuracy: 23.33%Submissions: 383K+Points: 4
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring 
the left subtree over the right subtree. 
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you
always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left 
boundary nodes.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 
*/

class Solution
{
    void addright(Node node,ArrayList<Integer> res)
    {
        if(node==null || (node.left==null && node.right==null))
        {
            return;    
        }
        
        if(node.right!=null)
        {
            addright(node.right,res);
        }
        
        else
        {
        addright(node.left,res);
        }
        
        if(!(node.left==null && node.right==null))
         res.add(node.data);
        
    }
    
    void addleafs(Node node,ArrayList<Integer> res)
    {
        if(node==null )
        {
            return ;
        }
        
        
        addleafs(node.left,res);
        if(node.left==null && node.right==null)
        {
            res.add(node.data);
        } 
        
        addleafs(node.right,res);
    }
    
    void addleft(Node curr,ArrayList<Integer> res)
    {
        
        while (curr != null) 
        {
            if (!(curr.left == null && curr.right == null)) {
                res.add(curr.data);
            }
    
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        
        
    }
    ArrayList<Integer> traverse(Node node)
    {
        ArrayList<Integer> res=new ArrayList<>();
        if(node.left==null && node.right==null){
        res.add(node.data);
        return res;    
        } 
     
        res.add(node.data);
        
       
        
        addleft(node.left,res);
        addleafs(node,res);
        
        addright(node.right,res);
        
       
        return res;
        
        
    }
	ArrayList <Integer> boundary(Node node)
	{
	    return traverse(node);
	}
}
