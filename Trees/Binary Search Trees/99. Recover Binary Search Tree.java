/*
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without 
changing its structure.
*/
class Solution {
    TreeNode first = null, second = null, third = null;
    TreeNode prev = null;

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (prev != null) {
            if (prev.val > root.val) {
                if (first == null) {
                    first = prev;
                    second = root;
                } else {
                    third = root;
                }
            }
        }
        prev = root;
        inorder(root.right);

    }

    public void recoverTree(TreeNode root) {
        int temp;
        inorder(root);

        if (third == null) {
            temp = first.val;
            first.val = second.val;
            second.val = temp;
        } else {
            temp = first.val;
            first.val = third.val;
            third.val = temp;
        }
    }
}
