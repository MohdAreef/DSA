// Given the head of a singly linked list, reverse the list, and return the reversed list.
// Iterative Implementation
class Solution {
    public ListNode revese(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {

            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;
        }
        return prev;

    }

    public ListNode reverseList(ListNode head) {
        return revese(head);
    }
}

//Recursive Implementation

class Solution {
   private ListNode temp = null;

    public void reverse(ListNode node, ListNode prev) {
        if (node == null)
            return;

        reverse(node.next, node);
        if (node.next == null)
            temp = node;
        node.next = prev;

    }

    public ListNode reverseList(ListNode head) {
        reverse(head, null);
        return temp;
    }
}
 
