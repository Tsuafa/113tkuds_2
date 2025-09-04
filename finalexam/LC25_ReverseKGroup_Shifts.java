package finalexam;

// LC25_ReverseKGroup_Shifts.java
import java.util.*;

public class LC25_ReverseKGroup_Shifts {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode dummy = new ListNode(0), cur = dummy;
        while (sc.hasNextInt()) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        sc.close();

        ListNode head = reverseKGroup(dummy.next, k);
        cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" ");
            cur = cur.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) kth = kth.next;
            if (kth == null) break; 

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroup = kth.next;

            
            ListNode prev = nextGroup, curr = groupStart;
            while (curr != nextGroup) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }
}

/*
時間複雜度: O(n)  // 每個節點走一次
空間複雜度: O(1)  // 原地反轉
*/
