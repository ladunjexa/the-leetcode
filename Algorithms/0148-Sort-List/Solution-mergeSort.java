class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode middle = findMiddleNode(head), nextOfMiddle = middle.next;
        middle.next = null;
        
        ListNode sortedLeft = sortList(head), sortedRight = sortList(nextOfMiddle);

        return merge(sortedLeft, sortedRight);
    }
    

    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode mergedList = new ListNode(-1), current = mergedList;
        
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }
        
        if(left != null)
            current.next = left;

        if(right != null)
            current.next = right;
            
        return mergedList.next;
    }
}
