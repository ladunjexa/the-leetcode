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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode current = head;
        ListNode next = current.next;

        while(current != null && next != null) {
            int temp = next.val;
            next.val = current.val;
            current.val = temp;

            if(next.next != null)
                current = next.next;
            else
                return head;
            
            if(current.next != null)
                next = current.next;
            else
                return head;
        }

        return head;
    }
}