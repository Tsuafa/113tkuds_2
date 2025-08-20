package midterm;


// M11_HeapSortWithTie.java
import java.util.*;

public class M11_HeapSortWithTie {

    static class Entry implements Comparable<Entry> {
        int score, idx;
        Entry(int s, int i) { score = s; idx = i; }
        public int compareTo(Entry o) {
            if (this.score != o.score) return o.score - this.score; 
            return o.idx - this.idx; 
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Entry[] arr = new Entry[n];
        for (int i = 0; i < n; i++) arr[i] = new Entry(sc.nextInt(), i);

       
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);

       
        for (int i = n - 1; i >= 0; i--) {
            Entry tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, i, 0);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].score + (i < n - 1 ? " " : "\n"));
        }
        sc.close();
    }

    static void heapify(Entry[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && arr[l].compareTo(arr[largest]) > 0) largest = l;
        if (r < n && arr[r].compareTo(arr[largest]) > 0) largest = r;
        if (largest != i) {
            Entry tmp = arr[i]; arr[i] = arr[largest]; arr[largest] = tmp;
            heapify(arr, n, largest);
        }
    }
}

/*
 * Time Complexity: O(n log n)
 * 說明：
 * 1. 建堆 bottom-up：O(n)
 * 2. 每次 Heap Sort 彈出元素並 heapify：n 次，每次 log n => O(n log n)
 * 3. 因此總時間複雜度為 O(n + n log n) = O(n log n)
 */
