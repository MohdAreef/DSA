/*
Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant 
of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.
*/

class Solution {
    public TreeNode bst(TreeNode node,int k)
    {
    if(node==null)
    {
    TreeNode temp=new TreeNode(k);
    return temp;
    }

    //explore
    if(k<node.val)
    {
    node.left=bst(node.left,k);
    }
    else
    {
    node.right=bst(node.right,k);
    }
    return node;
    }
   

    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root=bst(null,preorder[0]);

        for(int i=1;i<preorder.length;i++)
        {
        root=bst(root,preorder[i]);
        }
        return root;
    }
}


class Solution {
    private int index = 0;

    public TreeNode createBST(int[] arr, int upper) {

        if (index == arr.length || arr[index] > upper) {
            return null;
        }

        TreeNode root = new TreeNode(arr[index++]);

        root.left = createBST(arr, root.val);
        root.right = createBST(arr, upper);

        return root;

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return createBST(preorder, Integer.MAX_VALUE);

    }
}
