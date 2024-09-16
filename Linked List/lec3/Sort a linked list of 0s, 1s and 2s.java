/*
Given a linked list where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros 
segregate to the head side, 2s at the end of the linked list, and 1s in the middle of 0s and 2s.

Examples:

Input: LinkedList: 1->2->2->1->2->0->2->2
Output: 0->1->1->2->2->2->2->2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.
*/

class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node nationalflag(Node head)
    {
        Node dummyhead=new Node(-1);
        Node dummytail=new Node(-1);
        Node dummymid=new Node(-1);
        Node headnode=dummyhead,tailnode=dummytail,midnode=dummymid;
        // dummy.next=head;
        Node tail=null,curr=head;
        while(curr!=null)
        {
            Node next=curr.next;
            if(curr.data==0)
            {
                headnode.next=curr;
                headnode=curr;
                
                
            }
            else if(curr.data==1)
            {
                midnode.next=curr;
                midnode=curr;
            }
            else
            {
                tailnode.next=curr;
                tailnode=curr;
            }
            
            curr.next=null;
          
            curr=next;
        }
        
        if(dummymid.next!=null)
        {
        headnode.next=dummymid.next;
        midnode.next=dummytail.next;
        }
        else
        {
            headnode.next=dummytail.next;
        }
        if(dummyhead.next!=null) return dummyhead.next;
        if(dummymid.next!=null) return dummymid.next;
        return dummytail.next;
        
    }
    static Node segregate(Node head) {
        // add your code here
        return nationalflag(head);
        
    }
}
