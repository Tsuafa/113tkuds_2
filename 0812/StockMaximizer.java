import java.util.Collections;
import java.util.PriorityQueue;

public class StockMaximizer {

    public static int maxProfit(int[] prices, int k) { // O(n log n)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int buy = 0;

        while (buy < prices.length - 1) {
            while (buy < prices.length - 1 && prices[buy] >= prices[buy + 1]) {
                buy++;
            }
            int sell = buy + 1;
            while (sell < prices.length && prices[sell] >= prices[sell - 1]) {
                sell++;
            }
            if (sell - 1 > buy) {
                int profit = prices[sell - 1] - prices[buy];
                if (profit > 0) maxHeap.add(profit);
            }
            buy = sell;
        }

        int totalProfit = 0;
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            totalProfit += maxHeap.poll();
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {2, 4, 1};
        System.out.println(maxProfit(prices1, 2)); // 2

        int[] prices2 = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(prices2, 2)); // 7

        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices3, 2)); // 4
    }
}
