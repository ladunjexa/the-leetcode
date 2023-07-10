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
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroup(head, k, length(head));
    }

    public ListNode reverseKGroup(ListNode head, int k, int len) {
        if(head == null)
            return null;
        
        if(len < k)
            return head;
        
        ListNode prevNode = null, currentNode = head, nextNode = currentNode;

        for(int i = 0; i < k; i++) {
            if(currentNode != null) {
                nextNode = currentNode.next;
                currentNode.next = prevNode;
                prevNode = currentNode;
                currentNode = nextNode;
            }
        }

        head.next = reverseKGroup(currentNode, k, len - k);
        return prevNode;
    }

    private int length(ListNode head) {
        int c = 0;
        for(; head != null; c++, head = head.next);

        return c;
    }
}
