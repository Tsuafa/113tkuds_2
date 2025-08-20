package midterm;
import java.util.*;

public class M03_TopKConvenience {
   

    static class Item {
        String name;
        int qty;
        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), K = sc.nextInt();

       
        PriorityQueue<Item> heap = new PriorityQueue<>(new Comparator<Item>() {
            public int compare(Item a, Item b) {
                if (a.qty != b.qty) return Integer.compare(a.qty, b.qty);
                return a.name.compareTo(b.name);
            }
        });

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int qty = sc.nextInt();
            Item it = new Item(name, qty);

            if (heap.size() < K) {
                heap.offer(it);
            } else if (it.qty > heap.peek().qty ||
                       (it.qty == heap.peek().qty && it.name.compareTo(heap.peek().name) < 0)) {
                heap.poll();
                heap.offer(it);
            }
        }

       
        List<Item> result = new ArrayList<>(heap);
        result.sort(new Comparator<Item>() {
            public int compare(Item a, Item b) {
                if (b.qty != a.qty) return Integer.compare(b.qty, a.qty);
                return a.name.compareTo(b.name);
            }
        });

        for (Item it : result) {
            System.out.println(it.name + " " + it.qty);
        }

        sc.close();
    }
}

 /*
     * Time Complexity: O(n log K)
     * 說明：
     * 1) 每筆資料丟進大小為 K 的 Min-Heap，單次操作 O(log K)。
     * 2) 總共有 n 筆 → O(n log K)。
     * 3) 最後再對 K 筆結果排序 O(K log K)，可忽略。
     * 整體複雜度：O(n log K)。
     */