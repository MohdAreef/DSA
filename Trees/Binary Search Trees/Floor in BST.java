/*
Difficulty: MediumAccuracy: 51.06%Submissions: 76K+Points: 4
You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller 
than or equal to x.
Note: when x is smaller than the smallest node of BST then returns -1.
*/

class Solution {
    public static void floorvalue(Node node,int x,int[] arr)
    {
        if(node==null) return ;
        
        if(node.data==x)
        {
            arr[0]=x;
            return ;
        }
        
        if(node.data<x)
        {
            arr[0]=Math.max(arr[0],node.data);
            floorvalue(node.right,x,arr);
        }
        else
        {
            floorvalue(node.left,x,arr);
        }
    }
    public static int floor(Node root, int x) {
        // Code here
        if(root==null) return -1;
        
        int[] arr=new int[1];
        arr[0]=Integer.MIN_VALUE;
        floorvalue(root,x,arr);
        if(arr[0]==Integer.MIN_VALUE)
        {
            return -1;
        }
        return arr[0];
        
    }
}
