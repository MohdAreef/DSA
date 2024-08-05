class Solution {
    public int diameter(TreeNode node,int[] arr)
    {
        if(node==null) return 0;

        int lh=diameter(node.left,arr);
        int rh=diameter(node.right,arr);
    
       arr[0]=Math.max(arr[0],lh+rh);

        return Math.max(lh,rh) +1;
    }
    public int diameterOfBinaryTree(TreeNode node) {
        int[] arr=new int[1];
        arr[0]=0;

        int h=diameter(node,arr);
        return arr[0];
    }
}
