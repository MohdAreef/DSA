class Solution {
     public List<Integer> preorder(TreeNode node)
    {
        List<Integer> ans=new ArrayList<>();

        TreeNode curr=node;

        while(curr!=null)
        {
            if(curr.left==null)
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            else
            {
                TreeNode temp=curr.left;
                while(temp.right!=null && temp.right!=curr)
                {
                    temp=temp.right;
                }
                if(temp.right==null)
                {
                     temp.right=curr;
                     ans.add(curr.val);
                     curr=curr.left;
                }
                else
                {
                    temp.right=null;
                    
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorder(root);
    }
}
