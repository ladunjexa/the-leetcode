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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head.next, prev = head;
        int len = 1;

        while(curr != null) {
            len++;
            prev = curr;
            curr = curr.next;
        }

        prev.next = head;

        k = k % len;

        int indexToTerminate = len - k - 1, i = 0;

        curr = head;
        while(i < indexToTerminate) {
            curr = curr.next;
            i++;
        }

        ListNode result = curr.next;
        curr.next = null;

        return result;
    }
}
