/*
Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 
1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.
*/
class Solution {
    public int leftheight(TreeNode node) {
        int cnt = 0;
        while (node != null) {
            cnt++;
            node = node.left;
        }
        // System.out.println(cnt);
        return cnt;
    }

    public int rightheight(TreeNode node) {
        int cnt = 0;
        while (node != null) {
            cnt++;
            node = node.right;
        }
        return cnt;
    }

    public int count(TreeNode root) {
        if (root == null)
            return 0;

        int leftheight = leftheight(root);
        int rightheight = rightheight(root);
        if (leftheight == rightheight) {
            return (1 << (leftheight)) - 1;
        } else
            return 1 + count(root.left) + count(root.right);
    }

    public int countNodes(TreeNode root) {

        return count(root);

    }
}
