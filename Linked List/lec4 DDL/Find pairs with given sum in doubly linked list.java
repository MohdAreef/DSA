/*
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value 
target.
Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
*/

class Solution {
    
    public static ArrayList<ArrayList<Integer>> find(int target,Node head)
    {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Node tail=null;
        Node temp=head;
        while(temp!=null)
        {
            
            tail=temp;
            temp=temp.next;
        }
        while(head!=tail)
        {
            int sum=head.data+tail.data;
            if(sum==target)
            {  ArrayList<Integer> sub= new ArrayList<>();
               
               sub.add(head.data);
               sub.add(tail.data);
               
                res.add(sub);
                head=head.next;
            }
            else if(sum<target)
            {
                head=head.next;
            }
            else
            {
                tail=tail.prev;
            }
        }
        return res;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        
        return find(target,head);
    }
}
        
