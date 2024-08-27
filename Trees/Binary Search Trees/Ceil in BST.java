/*
Given a BST and a number X, find Ceil of X.
Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.

If Ceil could not be found, return -1.
*/
class Tree {
    // Function to return the ceil of given number in BST.
  
    void find(Node node,int key,int[] arr)
    {
        
        if(node==null) return ;
        
        if(node.data==key) 
        {
            arr[0]=key;
            return ;
        }
        
        if(node.data>key)
        {
            arr[0]=Math.min(arr[0],node.data);
            find(node.left,key,arr);
        }
        else
        {
            find(node.right,key,arr);
        }
    }
    int findCeil(Node root, int key) {
        if (root == null) return -1;
          int[] arr=new int[1];
        arr[0]=Integer.MAX_VALUE;
        find(root,key,arr);
       if( arr[0]==Integer.MAX_VALUE) return -1;
       
       return arr[0];
        // Code here
    }
}
