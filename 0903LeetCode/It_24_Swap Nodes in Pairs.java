package 0903LeetCode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // swap
            current.next = second;
            first.next = second.next;
            second.next = first;

            // move forward
            current = first;
        }

        return dummy.next;
    }
}
