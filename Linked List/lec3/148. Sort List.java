/*
Given the head of a linked list, return the list after sorting it in ascending order.
Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
*/


class Solution {
    public ListNode getMidNode(ListNode low)
    {
        ListNode slow=low,fast=slow.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode list1,ListNode list2)
    {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while(list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
            {
               temp.next=list1;
               temp=temp.next;
               list1=list1.next;
            }

            else
            {
               temp.next=list2;
               temp=temp.next;
               list2=list2.next;
            }  
             
        }
        while(list1!=null)
        {
            temp.next=list1;
            temp=list1;
            list1=list1.next;
        }
        while(list2!=null)
        {
            temp.next=list2;
            temp=list2;
            list2=list2.next;
        }
        return dummy.next;
    }


    public ListNode mergesort(ListNode head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }

            ListNode mid=getMidNode(head);
            ListNode left=head;
            ListNode right=mid.next;

            mid.next=null;

           left= mergesort(left);
           right= mergesort(right);
            
           return  merge(left,right);
     
    }

    public ListNode sortList(ListNode head) {
       return  mergesort(head);
    }
}
