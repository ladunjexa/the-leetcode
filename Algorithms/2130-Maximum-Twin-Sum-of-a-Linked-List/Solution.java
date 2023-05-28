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
    public int pairSum(ListNode head) {
        List<Integer> nodes = new ArrayList<Integer>();
        ListNode curr = head;
        
        while(curr != null) {
            nodes.add(curr.val);
            curr = curr.next;
        }

        int N = nodes.size(), max = 0;
        for(int i = 0; i < N / 2; i++)
            max = Math.max(max, nodes.get(i) + nodes.get(N - 1 - i));

        return max;
    }
}
