/*
You're given a binary tree. Your task is to find the size of the largest subtree within this binary tree that also satisfies the properties of a Binary Search Tree (BST). The size of a subtree is defined as the 
number of nodes it contains.

Note: A subtree of the binary tree is considered a BST if for every node in that subtree, the left child is less than the node, and the right child is greater 
than the node, without any duplicate values in the subtree.
*/
class Pair
{
    int size,largest,smallest;
    Pair(int size,int largest,int smallest)
    {
        this.size=size;
        this.largest=largest;
        this.smallest=smallest;
    }
}

class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    public static Pair  postorder(Node root)
    {
        if(root==null)
        {
          return new Pair(0,(int)-1e9,(int)1e9);    
        }
        
        Pair left=postorder(root.left);
        Pair right= postorder(root.right);
   
        if(left.largest<root.data && root.data <right.smallest)
        {
            int large=Math.max(right.largest,root.data);
            int small=Math.min(root.data,left.smallest);
            return new Pair(left.size+right.size+1,large,small);
        }
        
        else
        {
            return new Pair(Math.max(left.size,right.size),(int)1e9,(int)-1e9);
        }   
    }
    static int largestBst(Node root)
    {
        // Write your code here
        Pair temp=postorder(root);
        return temp.size;       
    }
    
}
