/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and 
return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/


class Solution {
    public ListNode addNumber(ListNode l1, ListNode l2) {
        ListNode head = null, temp = null, newnode;
        int carry = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;

            if (head == null) {
                newnode = new ListNode(sum % 10);
                newnode.next = null;
                head = newnode;
                temp = head;
                carry = sum / 10;
            } else {
                newnode = new ListNode(sum % 10);
                newnode.next = null;
                temp.next = newnode;
                temp = newnode;
                carry = sum / 10;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            newnode = new ListNode(sum % 10);
            newnode.next = null;
            temp.next = newnode;
            temp = newnode;
            carry = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            newnode = new ListNode(sum % 10);
            newnode.next = null;
            temp.next = newnode;
            temp = newnode;
            carry = sum / 10;
            l2 = l2.next;
        }
        if (carry != 0) {
            temp.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addNumber(l1, l2);
    }
}
