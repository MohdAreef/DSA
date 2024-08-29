/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
*/
class Solution {
    public void lowestpath(TreeNode node, TreeNode p, TreeNode q, List<List<TreeNode>> res, List<TreeNode> list) {
        // base condition
        if (node == null)
            return;
        if (node.val == p.val || node.val == q.val) {
            list.add(node);
            res.add(new ArrayList<TreeNode>(list));
            list.remove(list.size() - 1);

        }

        // explore
        list.add(node);
        lowestpath(node.left, p, q, res, list);
        lowestpath(node.right, p, q, res, list);
        list.remove(list.size() - 1);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<List<TreeNode>> res = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        lowestpath(root, p, q, res, list);
        System.out.println(res.size());
        // int size=Math.min(res.get(0).size(),res.get(1).size());
        TreeNode prenode = res.get(0).get(0);
        int i = 0, j = 0;
        while (i < res.get(0).size() && j < res.get(1).size()) {
            if (res.get(0).get(i).val != res.get(1).get(i).val) {
                return prenode;
            }
            prenode = res.get(0).get(i);
            j++;
            i++;
        }
        return prenode;

    }
}


// Another solution

class Solution {
    public TreeNode lowest(TreeNode node,TreeNode p,TreeNode q)
    {
        if(node==null) return null;
        if(node.val==p.val || node.val==q.val) return node;

        TreeNode left=lowest(node.left,p,q);
        TreeNode right=lowest(node.right,p,q);

        if(left==null) return right;
        if(right==null) return left;

        return node;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          return lowest(root,p,q);
    }
}
