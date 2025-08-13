import java.util.*;

class MultiLevelCacheSystem {
    class CacheNode {
        int key;
        String value;
        int freq;
        long time;
        CacheNode(int k, String v, long t) { key=k; value=v; freq=1; time=t; }
    }

    class CacheLevel {
        int capacity;
        int cost;
        PriorityQueue<CacheNode> heap;
        Map<Integer, CacheNode> map;
        CacheLevel(int cap, int cost) {
            this.capacity = cap;
            this.cost = cost;
            this.map = new HashMap<>();
            this.heap = new PriorityQueue<>((a,b) -> {
                double scoreA = (double)a.freq / this.cost;
                double scoreB = (double)b.freq / this.cost;
                if(scoreA != scoreB) return Double.compare(scoreA, scoreB);
                return Long.compare(a.time, b.time); // LRU tie-break
            });
        }

        void put(CacheNode node) {
            if(map.containsKey(node.key)) return;
            if(map.size() >= capacity) evict();
            map.put(node.key, node);
            heap.offer(node);
        }

        void evict() {
            CacheNode remove = heap.poll();
            if(remove != null) map.remove(remove.key);
        }

        void remove(CacheNode node) {
            heap.remove(node);
            map.remove(node.key);
        }
    }

    private CacheLevel L1, L2, L3;
    private long timestamp;

    public MultiLevelCacheSystem() {
        L1 = new CacheLevel(2, 1);
        L2 = new CacheLevel(5, 3);
        L3 = new CacheLevel(10, 10);
        timestamp = 0;
    }

    public String get(int key) {
        timestamp++;
        CacheNode node = null;
        if(L1.map.containsKey(key)) node = L1.map.get(key);
        else if(L2.map.containsKey(key)) node = L2.map.get(key);
        else if(L3.map.containsKey(key)) node = L3.map.get(key);
        else return null;

        node.freq++;
        node.time = timestamp;
        promote(node);
        return node.value;
    }

    public void put(int key, String value) {
        timestamp++;
        CacheNode node = new CacheNode(key, value, timestamp);
        if(L1.map.containsKey(key) || L2.map.containsKey(key) || L3.map.containsKey(key)) return;
        L3.put(node); // 新增資料先放最底層
        promote(node);
    }

    private void promote(CacheNode node) {
        // 簡單策略：頻繁存取往上層移
        if(L3.map.containsKey(node.key) && node.freq >= 3) {
            L3.remove(node);
            L2.put(node);
        }
        if(L2.map.containsKey(node.key) && node.freq >= 5) {
            L2.remove(node);
            L1.put(node);
        }
    }

    public void printStatus() {
        System.out.println("L1: " + L1.map.keySet());
        System.out.println("L2: " + L2.map.keySet());
        System.out.println("L3: " + L3.map.keySet());
    }

    public static void main(String[] args) {
        MultiLevelCacheSystem cache = new MultiLevelCacheSystem();
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.printStatus(); // L1: [], L2: [], L3: [1,2,3]

        cache.get(1); cache.get(1); cache.get(2);
        cache.printStatus(); // L1: [1,2] (簡化示意)
    }
}
