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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode result = new ListNode(-1);
        result.next = head;

        ListNode prev = result, curr = head;

        while(curr != null) {
            while(curr.next != null && curr.val == curr.next.val)
                curr = curr.next;
            
            if(prev.next == curr)
                prev = prev.next;
            else
                prev.next = curr.next;
            
            curr = curr.next;
        }

        return result.next;
    }
}
