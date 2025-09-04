package finalexam;


import java.util.*;

public class LC23_MergeKLists_Hospitals {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode[] lists = new ListNode[k];

        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(0), cur = dummy;
            while (true) {
                int v = sc.nextInt();
                if (v == -1) break;
                cur.next = new ListNode(v);
                cur = cur.next;
            }
            lists[i] = dummy.next;
        }
        sc.close();

        ListNode merged = mergeKLists(lists);
        ListNode cur = merged;
        while (cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) System.out.print(" ");
            cur = cur.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0), tail = dummy;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null) pq.offer(minNode.next);
        }
        return dummy.next;
    }
}

/*
時間複雜度: O(N log k)  // 每個節點進出堆一次，堆大小 ≤ k
空間複雜度: O(k)       // 優先隊列大小 ≤ k
*/
