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
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode firstpt = null;
        ListNode pt1 = null;
        ListNode pt2 = null;
        ListNode endpt = null;
        ListNode pt = head;
        while (pt != null) {
            if (pt.val < x) {
                if (firstpt == null) {
                    firstpt = pt;
                    pt1 = firstpt;
                } else {
                    pt1.next = pt;
                    pt1 = pt1.next;
                }
            } else {
                if (endpt == null) {
                    endpt = pt;
                    pt2 = endpt;
                } else {
                    pt2.next = pt;
                    pt2 = pt2.next;
                }
            }
            pt = pt.next;
        }
        
        if (firstpt != null) {
            pt1.next = endpt;
            if (endpt != null)
                pt2.next = null;
            return firstpt;
        } else {
            pt2.next = null;
            return endpt;
        }
        
    }
}
