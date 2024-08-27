/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public TreeNode build(int[] inorder, int startinorder, int endinorder, int[] postorder, int startpost, int endpost,
            HashMap<Integer, Integer> map) {
        if (startinorder > endinorder || startpost > endpost) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[endpost]);
        int index = map.get(node.val);
        int leftpart = index - startinorder;

        node.left = build(inorder, startinorder, index - 1, postorder, startpost, startpost + leftpart - 1, map);
        node.right = build(inorder, index + 1, endinorder, postorder, startpost + leftpart, endpost - 1, map);

        return node;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = inorder.length;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, n - 1, postorder, 0, n - 1, map);
    }
}
