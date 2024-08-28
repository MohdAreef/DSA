/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

class Solution {

    public boolean isvalid(TreeNode node, long low, long high) {
        if (node == null)
            return true;

        if (node.val <= low || node.val >= high) {
            return false;
        }
        // explore
        boolean left = isvalid(node.left, low, node.val);

        boolean right = isvalid(node.right, node.val, high);

        return left && right;
    }

    public boolean isValidBST(TreeNode root) {

        return isvalid(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }
}
