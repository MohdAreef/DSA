/*
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top 
to bottom.
*/
class Pair {
    int row;
    TreeNode node;

    Pair(int row, TreeNode node) {
        this.row = row;
        this.node = node;
    }
}

class Solution {
    public List<Integer> rightview(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        if (root != null) {

            queue.add(new Pair(0, root));
        }
        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            int row = temp.row;
            TreeNode node = temp.node;
            map.put(row, node.val);
            if (node.left != null) {
                queue.add(new Pair(row + 1, node.left));
            }

            if (node.right != null) {
                queue.add(new Pair(row + 1, node.right));
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public List<Integer> rightSideView(TreeNode root) {
        return rightview(root);
    }
}
 
