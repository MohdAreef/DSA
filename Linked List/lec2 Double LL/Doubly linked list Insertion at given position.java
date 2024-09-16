/*
Given a doubly-linked list, a position p, and an integer x. The task is to add a new node with value x at the position just after pth node in the
doubly linked list.

Example 1:

Input:
LinkedList: 2<->4<->5
p = 2, x = 6 
Output: 2 4 5 6
Explanation: p = 2, and x = 6. So, 6 is
inserted after p, i.e, at position 3
(0-based indexing).
*/

class GfG
{
    //Function to insert a new node at given position in doubly linked list.
    void add(Node head,int pos,int data)
    {
     Node dummy=new Node(-1);
     
     dummy.next=head;
     head.prev=dummy;
     Node curr=head;
     while(pos>0)
     {
         
         curr=curr.next;
         pos--;
     }
     
     Node newnode=new Node(data);
     
     newnode.prev=curr;
     newnode.next=curr.next;
     
     curr.next=newnode;
     if(newnode.next!=null)
     newnode.next.prev=newnode;
     
     head=dummy.next;
     head.prev=null;
    }
    void addNode(Node head_ref, int pos, int data)
	{
		// Your code here
		add(head_ref,pos,data);
	}
}
