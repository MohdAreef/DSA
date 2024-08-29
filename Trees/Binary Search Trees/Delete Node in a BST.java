/*
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the
BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
*/


class Solution {
    public TreeNode removenode(TreeNode node) {
        TreeNode prev = node;
        while (node.left != null) {
            prev = node;
            node = node.left;
        }

        // most importent (edge case)
        if (node != prev) {
            prev.left = node.right;
        }
        return node;
    }

    public TreeNode delete(TreeNode node, int key) {
        if (node == null)
            return node;

        if (node.val == key) {
            if (node.left == null && node.right == null)
                return null;
            else if (node.left == null && node.right != null) {
                return node.right;
            } else if (node.left != null && node.right == null) {
                return node.left;
            } else {
                TreeNode leftnode = removenode(node.right);
                // most importent (edge case)
                if (leftnode != node.right)
                    leftnode.right = node.right;

                leftnode.left = node.left;

                return leftnode;
            }

        }

        if (node.val < key)
            node.right = delete(node.right, key);
        else {
            node.left = delete(node.left, key);
        }

        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
}
