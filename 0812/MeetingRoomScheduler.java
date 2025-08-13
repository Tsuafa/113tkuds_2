import java.util.*;

public class MeetingRoomScheduler {

    // Part 1: 計算最少需要的會議室數
    public static int minMeetingRooms(int[][] intervals) { // O(n log n)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!heap.isEmpty() && interval[0] >= heap.peek()) {
                heap.poll();
            }
            heap.add(interval[1]);
        }
        return heap.size();
    }

    // Part 2: 在有限會議室下最大總會議時間
    public static int maxTotalMeetingTime(int[][] intervals, int rooms) { // O(n log n)
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // 按結束時間排序
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 儲存會議室結束時間
        int totalTime = 0;
        for (int[] interval : intervals) {
            if (heap.size() < rooms) {
                heap.add(interval[1]);
                totalTime += interval[1] - interval[0];
            } else if (heap.peek() <= interval[0]) {
                heap.poll();
                heap.add(interval[1]);
                totalTime += interval[1] - interval[0];
            }
        }
        return totalTime;
    }

    public static void main(String[] args) {
        int[][] meetings1 = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(meetings1)); // 2

        int[][] meetings2 = {{1,4},{2,3},{4,6}};
        System.out.println(maxTotalMeetingTime(meetings2, 1)); // 5
    }
}
