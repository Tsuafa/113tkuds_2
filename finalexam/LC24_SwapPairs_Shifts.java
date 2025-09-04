package finalexam;


import java.util.*;

public class LC24_SwapPairs_Shifts {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode dummy = new ListNode(0), cur = dummy;
        while (sc.hasNextInt()) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        sc.close();

        ListNode swapped = swapPairs(dummy.next);
        cur = swapped;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" ");
            cur = cur.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode a = prev.next;
            ListNode b = a.next;

            
            prev.next = b;
            a.next = b.next;
            b.next = a;

            prev = a; 
        }
        return dummy.next;
    }
}

/*
時間複雜度: O(n)  // 每個節點訪問一次
空間複雜度: O(1)  // 僅使用常數指標
*/
