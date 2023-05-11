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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int immed = 0;
        ListNode newList = new ListNode(Integer.MIN_VALUE);
        ListNode current = newList;

        while(l1 != null || l2 != null) {
            if(l1 != null) {
                immed += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                immed += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(immed % 10);
            current = current.next;
            immed /= 10;
        }

        if(immed > 0)
            current.next = new ListNode(immed);

        return newList.next;
    }
}