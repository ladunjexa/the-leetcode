/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) 
            return null;
        
        ListNode st = headA, nd = headB;
        
        while(st != nd){
            st = (st == null)? headB : st.next;
            nd = (nd == null)? headA : nd.next;    
        }
        
        return st;
    }
}
