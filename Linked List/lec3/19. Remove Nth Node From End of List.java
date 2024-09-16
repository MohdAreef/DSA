/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int res = len - n;
        curr = head;
        if (res < 0) {
            return head;
        } else if (res == 0) {
            return head.next;
        }

        else {
            for (int i = 1; i <= res - 1; i++) {
                curr = curr.next;
            }
            if (curr.next != null) {
                curr.next = curr.next.next;
            } else {
                curr.next = null;
            }

            return head;
        }
    }
}
