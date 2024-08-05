class Solution {
    public int height(TreeNode node) {
        if (node == null)
            return 0;

        int lh = height(node.left);
        int rh = height(node.right);
        if (lh == -1 || rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        int h = height(root);
        if (h == -1)
            return false;
        return true;
    }
}
