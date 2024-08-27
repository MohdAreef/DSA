class Solution {

    public TreeNode search(TreeNode node, int val) {

        if (node != null) {
            // explore
            if (node.val == val)
                return node;

            if (val < node.val) {
                return search(node.left, val);
            } else {
                return search(node.right, val);
            }

        }

        return null;

    }

    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }
}
