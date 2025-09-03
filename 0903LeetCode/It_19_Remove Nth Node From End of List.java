package 0903LeetCode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 建立 dummy 節點，方便處理刪除 head 的情況
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;

        // 先讓 fast 走 n+1 步，確保 slow 指到要刪除節點的前一個
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 同步移動 fast 和 slow
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 刪除目標節點
        slow.next = slow.next.next;

        return dummy.next;
    }
}
