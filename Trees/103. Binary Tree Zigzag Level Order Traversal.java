/*
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left 
for the next level and alternate between).
*/
class Solution {
    public List<List<Integer>> zigzag(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        if (root != null) {

            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            // System.out.println(size);
            for (int i = 0; i < size; i++) {
                list.add(0); // or any other default value
            }
            // System.out.println(list.toString());

            for (int i = 0; i < size; i++) {

                TreeNode temp1 = queue.poll();
                int index = flag ? i : size - 1 - i;
                list.set(index, temp1.val);
                if (temp1.left != null) {
                    queue.add(temp1.left);
                }
                if (temp1.right != null) {
                    queue.add(temp1.right);
                }

            }
            // System.out.println(list.toString());
            res.add(list);
            flag = !flag;

        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return zigzag(root);
    }
}
