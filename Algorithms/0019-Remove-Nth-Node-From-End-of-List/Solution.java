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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int nodes = 0;
        
        while(current != null) {
            current = current.next;
            nodes++;
        }

        int nth = (nodes - n);
        
        if(nth == 0)
            head = head.next;
        else {
            ListNode previous = head;
            while((nth - 1) != 0) {
                previous = previous.next;
                nth--;
            }
            previous.next = (previous.next).next;
        }

        return head;
    }
}