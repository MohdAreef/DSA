/*
Given a Binary Tree. Check for the Sum Tree for every node except the leaf node. Return true if it is a Sum Tree otherwise, return false.

A SumTree is a Binary Tree where the value of a node is equal to the sum of the nodes present in its left subtree and right subtree. An empty tree 
is also a Sum Tree as the sum of an empty tree can be considered to be 0. A leaf node is also considered a Sum Tree.

Examples :

Input:
    3
  /   \    
 1     2
Output: true
Explanation: The sum of left subtree and right subtree is 1 + 2 = 3, which is the value of the root node. Therefore,the given binary tree is a sum tree.
*/

class Solution {
    int sumtree(Node root)
    {
        //base condition
        if(root==null) return 0;
        if(root.left==null && root.right==null) return root.data;
        
        //explore
        int left=sumtree(root.left);
        int right=sumtree(root.right);
        if(left==-1 || right==-1) return -1;
        if(left+right==root.data)
        {
            return left+right+root.data;
        }
        return -1;
    }
    boolean isSumTree(Node root) {
        // Your code here
        
        int res=sumtree(root);
        if(res==-1) return false;
        else return true;
    }
}
