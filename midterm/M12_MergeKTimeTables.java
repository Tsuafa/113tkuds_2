package midterm;
// M12_MergeKTimeTables.java
import java.util.*;

public class M12_MergeKTimeTables {

    static class Entry implements Comparable<Entry> {
        int time, listIdx, idx;
        Entry(int t, int l, int i) { time = t; listIdx = l; idx = i; }
        public int compareTo(Entry o) { return this.time - o.time; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) arr[j] = sc.nextInt();
            lists.add(arr);
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>();
       
        for (int i = 0; i < K; i++) {
            if (lists.get(i).length > 0)
                pq.add(new Entry(lists.get(i)[0], i, 0));
        }

        List<Integer> merged = new ArrayList<>();
        while (!pq.isEmpty()) {
            Entry e = pq.poll();
            merged.add(e.time);
            int nextIdx = e.idx + 1;
            if (nextIdx < lists.get(e.listIdx).length) {
                pq.add(new Entry(lists.get(e.listIdx)[nextIdx], e.listIdx, nextIdx));
            }
        }

      
        for (int i = 0; i < merged.size(); i++) {
            System.out.print(merged.get(i) + (i < merged.size()-1 ? " " : "\n"));
        }
        sc.close();
    }
}
