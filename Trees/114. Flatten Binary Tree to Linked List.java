// this problem has two implementaion  1. using recursion 2. using MORRIES preorder 
/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is 
always null. The "linked list" should be in the same order as a pre-order traversal of the binary tree.
*/


class Solution {
    TreeNode prev = null;

    public void flattolist(TreeNode node) {
        if (node == null)
            return;

        flattolist(node.right);
        flattolist(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }

    public void morries(TreeNode node) {
        TreeNode curr = node;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            } else {
                curr = curr.right;
            }
        }
    }

    public void flatten(TreeNode root) {

        // flattolist(root);
        morries(root);

    }
}
