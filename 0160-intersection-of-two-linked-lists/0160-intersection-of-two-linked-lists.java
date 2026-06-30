/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        // Move the longer list ahead
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Move both pointers together
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA; // Intersection node or null
    }

    private int getListLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}