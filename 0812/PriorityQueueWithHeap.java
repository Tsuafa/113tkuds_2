import java.util.PriorityQueue;

public class PriorityQueueWithHeap {
    private static class Task implements Comparable<Task> {
        String name;
        int priority;
        long timestamp;
        static long counter = 0;

        Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
            this.timestamp = counter++;
        }

        @Override
        public int compareTo(Task other) {
            if (this.priority != other.priority) {
                return Integer.compare(other.priority, this.priority); // 高優先級先
            }
            return Long.compare(this.timestamp, other.timestamp); // 先加入的先
        }
    }

    private PriorityQueue<Task> queue;

    public PriorityQueueWithHeap() { // O(1)
        queue = new PriorityQueue<>();
    }

    public void addTask(String name, int priority) { // O(log n)
        queue.add(new Task(name, priority));
    }

    public String executeNext() { // O(log n)
        if (queue.isEmpty()) return null;
        return queue.poll().name;
    }

    public String peek() { // O(1)
        if (queue.isEmpty()) return null;
        return queue.peek().name;
    }

    public void changePriority(String name, int newPriority) { // O(n log n)
        PriorityQueue<Task> newQueue = new PriorityQueue<>();
        for (Task task : queue) {
            if (task.name.equals(name)) {
                newQueue.add(new Task(name, newPriority));
            } else {
                newQueue.add(task);
            }
        }
        queue = newQueue;
    }

    public static void main(String[] args) {
        PriorityQueueWithHeap pq = new PriorityQueueWithHeap();
        pq.addTask("備份", 1);
        pq.addTask("緊急修復", 5);
        pq.addTask("更新", 3);

        System.out.println(pq.executeNext()); // 緊急修復
        System.out.println(pq.executeNext()); // 更新
        System.out.println(pq.executeNext()); // 備份
    }
}
