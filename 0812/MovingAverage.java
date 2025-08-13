import java.util.*;

public class MovingAverage {
    private int size;
    private Queue<Integer> window;
    private long sum;
    private PriorityQueue<Integer> maxHeap; // 小的一半
    private PriorityQueue<Integer> minHeap; // 大的一半
    private TreeMap<Integer, Integer> freqMap; // 支援 O(log n) min/max

    public MovingAverage(int size) {
        this.size = size;
        this.window = new LinkedList<>();
        this.sum = 0;
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
        this.freqMap = new TreeMap<>();
    }

    public double next(int val) {
        window.offer(val);
        sum += val;

        // 更新中位數 heaps
        if (maxHeap.isEmpty() || val <= maxHeap.peek()) {
            maxHeap.offer(val);
        } else {
            minHeap.offer(val);
        }
        balanceHeaps();

        // 更新 min/max
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);

        // 移除舊值
        if (window.size() > size) {
            int old = window.poll();
            sum -= old;

            // 延遲刪除策略
            freqMap.put(old, freqMap.get(old) - 1);
            if (freqMap.get(old) == 0) freqMap.remove(old);

            // 從 heaps 延遲刪除，實作時只是讓 poll 期間跳過已刪除元素
            cleanHeap(maxHeap);
            cleanHeap(minHeap);
            balanceHeaps();
        }

        return sum * 1.0 / window.size();
    }

    private void balanceHeaps() {
        while (maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
        whil
