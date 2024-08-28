/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
*/


// below solution has both two implementations
class Solution {

    public int kth(TreeNode node, List<Integer> res, int[] arr, int k) {
        if (node == null)
            return -1;

        int left = kth(node.left, res, arr, k);
        res.add(node.val);
        arr[0]++;
        if (arr[0] == k)
            return node.val;
        int right = kth(node.right, res, arr, k);

        return Math.max(left, right);

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[1];
        arr[0] = 0;
        return kth(root, res, arr, k);

        // return res.get(k-1);
    }
}
