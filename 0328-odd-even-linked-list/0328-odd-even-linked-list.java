/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;

        // Maintain the head of the even list
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            // Update pointers for odd list
            odd.next = odd.next.next;
            odd = odd.next;

            // Update pointers for even list
            even.next = even.next.next;
            even = even.next;
        }

        // Attach the even list after the odd list
        odd.next = evenHead;

        return head;
    }
}