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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<Integer>();

        for(ListNode head : lists) {
            ListNode copy = head;

            while(copy != null) {
                l.add(copy.val);
                copy = copy.next;
            }
        }

        Collections.sort(l);

        ListNode out = new ListNode(-1), copy = out;

        for(int v : l) {
            copy.next = new ListNode(v);
            copy = copy.next;
        }

        return out.next;
    }
}
