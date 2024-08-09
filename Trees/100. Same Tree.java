/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/
class Solution {
    public boolean symmetric(TreeNode node1, TreeNode node2) {
        // base condition
        if (node1 == null && node2 == null)
            return true;
        if ((node1 != null && node2 == null) || (node1 == null && node2 != null))
            return false;

        // explore
        boolean left = symmetric(node1.left, node2.left);
        boolean right = symmetric(node1.right, node2.right);
        if (left == false || right == false) {
            return false;
        }
        if (node1.val == node2.val) {
            return true;
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        return symmetric(p, q);
    }
}
