import java.util.*;


public class M01_BuildHeap {
    

    private static boolean compare(int a, int b, boolean isMax) {
        return isMax ? a > b : a < b;
    }

    private static void heapifyDown(int[] arr, int n, int i, boolean isMax) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int candidate = i;

            if (left < n && compare(arr[left], arr[candidate], isMax)) {
                candidate = left;
            }
            if (right < n && compare(arr[right], arr[candidate], isMax)) {
                candidate = right;
            }
            if (candidate != i) {
                int tmp = arr[i];
                arr[i] = arr[candidate];
                arr[candidate] = tmp;
                i = candidate; // 繼續往下調整
            } else {
                break;
            }
        }
    }

    private static void buildHeap(int[] arr, boolean isMax) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(arr, n, i, isMax);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean isMax = type.equalsIgnoreCase("max");

        buildHeap(arr, isMax);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
        sc.close();
    }
}

/*
     * Time Complexity: O(n)
     * 說明：
     * 1) 自底向上建堆從最後一個非葉節點 (n/2 - 1) 開始 heapify。
     * 2) 雖然單次 heapify 最壞需 O(log n)，但大多數節點高度較小。
     * 3) 總和成本 = Σ(節點數 × 高度) ≈ O(n)，因此建堆為線性時間。
     */