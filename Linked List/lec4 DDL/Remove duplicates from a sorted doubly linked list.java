/*
Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.

Example 1:

Input:
n = 6
1<->1<->1<->2<->3<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of node with value 1 is 
retained, rest nodes with value = 1 are deleted.
*/

class Solution{
    Node remove(Node head)
    {
        Node curr=head;
        while(curr!=null)
        {
            Node next=curr.next;
            if(next!=null)
            {
                
                if(curr.data==next.data)
                {
                    curr.next=next.next;
                    if(next.next!=null)
                    next.next.prev=curr;
                }
                
                else
                   curr=curr.next;
            }
            else
            {
                curr=curr.next;
            }
          
        }
        return head;
    }
    Node removeDuplicates(Node head){
        // Code Here.
        return remove(head);
    }
}
