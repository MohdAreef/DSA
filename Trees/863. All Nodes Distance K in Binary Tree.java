/*
Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a 
distance k from the target node.

You can return the answer in any order.
  
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
Output: [7,4,1]
Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
*/

class Solution {
    public void findparent(TreeNode node, TreeNode parent, HashMap<Integer, TreeNode> map) {
        if (node == null)
            return;

        map.put(node.val, parent);
        findparent(node.left, node, map);
        findparent(node.right, node, map);
    }

    public List<Integer> findnodes(TreeNode root, TreeNode target, int k, HashMap<Integer, TreeNode> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean[] vis = new boolean[map.size()];
        Arrays.fill(vis, false);
        int count = 0;
        queue.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (count == k)
                break;
            for (int i = 0; i < size; i++) {

                TreeNode temp = queue.poll();
                if (temp.left != null && !vis[temp.left.val]) {
                    vis[temp.left.val] = true;
                    queue.add(temp.left);
                }
                if (temp.right != null && !vis[temp.right.val]) {
                    vis[temp.right.val] = true;
                    queue.add(temp.right);
                }
                if (map.get(temp.val) != null && !vis[temp.val]) {
                    vis[temp.val] = true;
                    queue.add(map.get(temp.val));
                }
            }
            count++;
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            res.add(t.val);
        }
        return res;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        HashMap<Integer, TreeNode> map = new HashMap<>();
        findparent(root, null, map);

        return findnodes(root, target, k, map);

    }
}
