/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, 
so please be creative and come up with different approaches yourself.
*/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        if (root == null)
            return "";
        q.add(root);
        sb.append(root.val);
        sb.append('.');
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                sb.append(curr.left.val);
                sb.append('.');
                q.add(curr.left);
            } else {
                sb.append('#');
                sb.append('.');
            }

            if (curr.right != null) {
                sb.append(curr.right.val);
                sb.append('.');
                q.add(curr.right);
            } else {
                sb.append('#');
                sb.append('.');
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<TreeNode> q = new LinkedList<>();

        if (data.length() == 0 || data.charAt(0) == '#')
            return null;
        int i = 0;

        String str[] = data.split("\\.");
        System.out.println(Arrays.toString(str));
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        q.add(root);
        i++;
        int n = str.length;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (i < n && str[i].equals("#")) {

                curr.left = null;
            } else {
                TreeNode leftnode = new TreeNode(Integer.parseInt(str[i]));
                curr.left = leftnode;
                q.add(leftnode);
            }
            i++;

            if (i < n && str[i].equals("#")) {

                curr.right = null;
            } else {
                TreeNode rightnode = new TreeNode(Integer.parseInt(str[i]));
                curr.right = rightnode;
                q.add(rightnode);
            }

            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
