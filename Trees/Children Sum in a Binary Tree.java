/*
Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of their child nodes. Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.

For every node, data value must be equal to the sum of data values in left and right children. Consider data value as 0 for NULL child.  Also, leaves are considered to follow the property.

Example 1:

Input:
Binary tree
       35
      /   \
     20  15
    /  \  /  \
   15 5 10 5
Output: 
1
Explanation: 
Here, every node is sum of its left and right child.
*/

class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int issum(Node node)
    {
        //base condition
        if(node==null) return 0;
        if(node.left==null && node.right==null) return node.data;
        
        //explore
        int left=issum(node.left);
        int right=issum(node.right);
        if(left==-1 || right==-1)
        {
            return -1;
        }
        if(left+right==node.data)
        {
            return node.data;
        }
        return -1;
    }
    public static int isSumProperty(Node root)
    {
        // add your code here
        int res=issum(root);
        return res==-1 ? 0 : 1;
    }
}
