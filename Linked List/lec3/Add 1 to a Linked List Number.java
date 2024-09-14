/*
You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating
all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
*/

class Solution {
   private int carry=1;
    public void  add(Node node)
    {
        if(node==null) return ;
        
        //explore
        add(node.next);
        int sum=node.data + carry;
        
        node.data=sum%10;
        carry=sum/10;
        
    }
    public Node addOne(Node head) {
        // code here.
        add(head);
        if(carry!=0)
        {
            Node newnode=new Node(carry);
            newnode.next=head;
            return newnode;
        }
        return head; 
    }
}
