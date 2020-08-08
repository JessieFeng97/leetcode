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
        ArrayList<ListNode> list1 = new ArrayList<ListNode>();
        ArrayList<ListNode> list2 = new ArrayList<ListNode>();
        
        while(l1 != null) {
            list1.add(l1);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            list2.add(l2);
            l2 = l2.next;
        }
        
        int i1 = list1.size() - 1;
        int i2 = list2.size() - 1;
        int count = 0;
        int cur = 0;
        int carry = 0;
        ListNode lastnode = new ListNode();
        while (i1 >= 0 && i2 >= 0) {
            if (count == 0) {
                cur = list1.get(i1).val + list2.get(i2).val;
                if (cur >= 10) carry = 1;
                cur = cur % 10;
                lastnode = new ListNode(cur);
                count++;
            } else {
                cur = list1.get(i1).val + list2.get(i2).val + carry;
                carry = 0;
                if (cur >= 10) carry = 1;
                cur = cur % 10;
                lastnode = new ListNode(cur, lastnode);
            }
            i1--;
            i2--;
        }
        while (i1 >= 0) {
            cur = list1.get(i1).val + carry;
            carry = 0;
            if (cur >= 10) carry = 1;
            cur = cur % 10;
            lastnode = new ListNode(cur, lastnode);
            i1--;
        }
        while (i2 >= 0) {
            cur = list2.get(i2).val + carry;
            carry = 0;
            if (cur >= 10) carry = 1;
            cur = cur % 10;
            lastnode = new ListNode(cur, lastnode);
            i2--;
        }
        if (carry == 1) lastnode = new ListNode(1, lastnode);
        return lastnode;
    }
}
