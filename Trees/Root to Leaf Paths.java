/*
Given a Binary Tree of nodes, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Example 1:

Input:
       1
    /     \
   2       3
Output: 
1 2 
1 3 
Explanation: 
All possible paths:
1->2
1->3
*/

class Solution {
    public static void  findpaths(Node node,ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res)
    {
        //base condition
        if(node==null)
        {
            return ;
        }
        
        if(node.left==null && node.right==null)
        {
            list.add(node.data);
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return ;
        }
        
        
        //explore
        list.add(node.data);
        findpaths(node.left,list,res);
        findpaths(node.right,list,res);
        list.remove(list.size()-1);
        
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
         // code here
        
         ArrayList<ArrayList<Integer>> res=new ArrayList<>();
         ArrayList<Integer> list=new ArrayList<>();
         
         findpaths(root,list,res);
         
         return res;
    }
}
        
