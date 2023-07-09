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
    public ListNode sortList(ListNode head) {
        List<Integer> arrayList = new ArrayList<Integer>();

        ListNode pointer = head,sortedList = new ListNode(-1), sortedPointer = sortedList;

        while(pointer != null) {
            arrayList.add(pointer.val);
            pointer = pointer.next;
        }

        Collections.sort(arrayList);

        for(int i = 0; i < arrayList.size(); i++) {
            ListNode newNode = new ListNode(arrayList.get(i));

            sortedPointer.next = newNode;
            sortedPointer = sortedPointer.next;   
        }

        return sortedList.next;
    }
}
