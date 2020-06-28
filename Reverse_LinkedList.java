class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode tmp;
        if (head == null) return null;
        while(head != null) {
            tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }
}
