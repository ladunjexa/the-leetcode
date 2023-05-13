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
    public boolean isPalindrome(ListNode head) {
        ListNode current = head;
        List<Integer> values = new ArrayList<>();

        while(current != null) {
            values.add(current.val);
            current = current.next;
        }

        int end = values.size() - 1;

        for(int i = 0; i < values.size(); i++)
            if(values.get(i) == values.get(end))
                end--;
            else
                return false;
        
        return true;
    }
}
