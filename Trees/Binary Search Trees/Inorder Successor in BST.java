//Given a BST, and a reference to a Node x in the BST. Find the Inorder Successor of the given node in the BST.

class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
   private Node temp=null;
    public void  next(Node node,Node x)
    {
        if(node==null) return ;
        
        if(node.data<x.data)
        {
            next(node.right,x);
        }
        else if(node.data>x.data)
        {
            if(temp==null)
            temp=node;
            else 
            {
                if(node.data<temp.data)
                 temp=node;
            }
            next(node.left,x);
        }
        else
        {
            next(node.right,x);
        }
       
        
    }
	public Node inorderSuccessor(Node root,Node x)
         {
          //add code here.
          
        next(root,x);
        return temp;

         }
}
