/*
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or 
equal to x.
For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
*/

class Solution {
    private ListNode pre = null;

    public ListNode middle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode deleteMiddle(ListNode head) {
        ListNode midnode = middle(head);
        if (pre != null) {
            pre.next = midnode.next;
            return head;
        } else
            return pre;

    }
}
