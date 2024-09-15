/*
// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

class Solution {
    public ListNode middle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;

            node = temp;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode midnode = middle(head);
        ListNode newnode = reverse(midnode);

        while (head != null && newnode != null) {
            if (head.val != newnode.val) {
                return false;
            }
            head = head.next;
            newnode = newnode.next;
        }

        if (newnode != null && newnode.next != null)
            return false;

        return true;
    }
}
