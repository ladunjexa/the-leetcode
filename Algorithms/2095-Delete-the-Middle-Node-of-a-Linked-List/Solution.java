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
    public ListNode deleteMiddle(ListNode head) {
        List<Integer> nodes = new ArrayList<Integer>();
        ListNode curr = head, list = new ListNode(-1);

        while(curr != null) {
            nodes.add(curr.val);
            curr = curr.next;
        }

        nodes.remove((nodes.size()) / 2);

        curr = list;
        
        for(int i = 0; i < nodes.size(); i++) {
            ListNode newNode = new ListNode(nodes.get(i));
            curr.next = newNode;
            curr = curr.next;
        }

        return list.next;
    }
}
