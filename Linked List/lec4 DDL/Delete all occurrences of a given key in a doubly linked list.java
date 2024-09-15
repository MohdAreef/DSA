/*
You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return 
the new DLL.

Example1:

Input: 
2<->2<->10<->8<->4<->2<->5<->2
2
Output: 
10<->8<->4<->5
Explanation: 
All Occurences of 2 have been deleted.
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
