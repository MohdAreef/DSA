/*
Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, 
otherwise return 0.

Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist. If c is 0, then there is no loop.
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    public Node count(Node head)
    {
        Node slow=head,fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast)
            {
                return slow;
            }
            
        }
        return null;
    }
    public int countNodesinLoop(Node head) {
        // Add your code here.
        
        Node collidenode=count(head);
        
        if(collidenode==null) return 0;
        
        int cnt=1;
        Node temp=collidenode;
        temp=temp.next;
        while(temp!=collidenode)
        {
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
}
