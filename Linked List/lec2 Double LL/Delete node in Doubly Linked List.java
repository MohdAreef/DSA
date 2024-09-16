/*
Given a Doubly Linked list and a position. The task is to delete a node from a given position (position starts from 1) in a doubly linked list and 
return the head of the doubly Linked list.

Examples:
Input: LinkedList = 1 <--> 3 <--> 4, x = 3
Output: 1 <--> 3
Explanation: After deleting the node at position 3 (position starts from 1),the linked list will be now as 1 <--> 3.
*/

class Solution {
    public Node delete(Node head,int x)
    {
        Node dummy=new Node(-1);
        dummy.next=head;
        Node curr=dummy;
        head.prev=dummy;
        while(x>0)
        {
            curr=curr.next;
            x--;
        } 
        Node next=curr.next;
        Node prev=curr.prev;
        if(next!=null)
        next.prev=prev;
        
        prev.next=next;
        
        return dummy.next;
    }
    public Node deleteNode(Node head, int x) {
        // code here
        return delete(head,x);
    }
}
