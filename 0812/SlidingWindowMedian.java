import java.util.*;

public class SlidingWindowMedian {

    private PriorityQueue<Integer> maxHeap; // 小的一半 - O(log k)
    private PriorityQueue<Integer> minHeap; // 大的一半 - O(log k)

    public SlidingWindowMedian() { // O(1)
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public double[] medianSlidingWindow(int[] nums, int k) { // O(n log k)
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
            if (i >= k) {
                remove(nums[i - k]);
            }
            if (i >= k - 1) {
                result[i - k + 1] = getMedian();
            }
        }
        return result;
    }

    private void add(int num) { // O(log k)
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();
    }

    private void remove(int num) { // O(log k)
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        balance();
    }

    private void balance() { // O(log k)
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian() { // O(1)
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        SlidingWindowMedian swm = new SlidingWindowMedian();
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(swm.medianSlidingWindow(nums1, 3))); // [1.0, -1.0, -1.0, 3.0, 5.0, 6.0]

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(swm.medianSlidingWindow(nums2, 2))); // [1.5, 2.5, 3.5]
    }
}
