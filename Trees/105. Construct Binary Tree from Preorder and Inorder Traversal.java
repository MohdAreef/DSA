/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of 
the same tree, construct and return the binary tree.
*/
class Solution {
    public TreeNode build(int preindex,int preend,int instart,int inend,int[] preorder,int[] inorder,Map<Integer,Integer> map)
    {
      if(preindex>preend || instart> inend) return null;
       
       TreeNode node=new TreeNode(preorder[preindex]);
       int index=map.get(node.val);
       int remaining=index-instart;

       node.left=build(preindex+1,preindex+remaining,instart,index-1,preorder,inorder,map);
       node.right=build(preindex+remaining+1,preend,index+1,inend,preorder,inorder,map);
       return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        int n=preorder.length;
        return build(0,n-1,0,n-1,preorder,inorder,map);
    }
}
