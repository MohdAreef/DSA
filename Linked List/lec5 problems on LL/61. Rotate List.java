/*
Given the head of a linked list, rotate the list to the right by k places.
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
*/
class Solution {

    // getter method to find the length of llsit
    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    // to find the rotate point of the llist
    public ListNode getRotatePoint(ListNode head, int k) {
        int len = length(head);

        int rotatePoint = len - k;
        ListNode newnode = head;
        int cnt = 0;
        while (newnode != null) {
            cnt++;
            if (cnt == rotatePoint) {
                return newnode;
            }
            newnode = newnode.next;

        }
        return null;
    }

    // rotate at the Kth point
    public ListNode rotate(ListNode head, int k) {
        int len = length(head);
        if (len == 0)
            return head;
        k = k % len;
        if (k == 0)
            return head;
        ListNode newnode = getRotatePoint(head, k);
        ListNode newhead = newnode.next;
        newnode.next = null;
        ListNode temp = newhead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        return newhead;

    }

    public ListNode rotateRight(ListNode head, int k) {
        return rotate(head, k);
    }
}
