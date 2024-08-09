//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

class Solution {
    public TreeNode reverse(TreeNode node) {
        // base condition
        if (node == null) {
            return node;
        }
        if (node.left == null && node.right == null) {
            return node;
        }

        // explore
        TreeNode temp = node.right;
        node.right = reverse(node.left);

        node.left = reverse(temp);

        return node;
    }

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

    public boolean isSymmetric(TreeNode root) {

        if (root.left != null) {
            root.left = reverse(root.left);
        }
        if (root.left != null && root.right != null) {

            return symmetric(root.left, root.right);
        }
        if (root.left == null && root.right == null) {

            return true;
        }
        return false;

    }
}
 
