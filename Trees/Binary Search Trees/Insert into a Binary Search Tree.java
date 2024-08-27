/*
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion.
It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
*/

 class Solution {
    public TreeNode insert(TreeNode node ,int val)
    {
        if(node==null)
        {
            TreeNode temp=new TreeNode(val);
            return temp;
        }

        if(node.val>val)
        {
           node.left=  insert(node.left,val);
        }
        else
        {
          node.right=   insert(node.right,val);
        }
        return node;

        
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root,val);
    }
}
