/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no 
intersection at all, return null.
For example, the following two linked lists begin to intersect at node c1:
The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.
*/
public class Solution {
    public ListNode getnode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int lenA = 0, lenB = 0;
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }
        int difflen = 0;
        boolean flag = false;
        System.out.println(lenA + " " + lenB);
        if (lenA > lenB) {
            flag = true;
            curr = headA;
            difflen = lenA - lenB;
            while (difflen > 0) {
                difflen--;
                curr = curr.next;
            }
        } else {
            curr = headB;
            difflen = lenB - lenA;
            while (difflen > 0) {
                difflen--;
                curr = curr.next;
            }
        }

        if (flag == true) {

            while (curr != null && headB != null) {
                if (headB == curr)
                    return curr;
                curr = curr.next;
                headB = headB.next;
            }
        } else {
            while (curr != null && headA != null) {
                if (headA == curr)
                    return curr;
                curr = curr.next;
                headA = headA.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getnode(headA, headB);
    }
}
