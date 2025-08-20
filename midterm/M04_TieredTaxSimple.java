package midterm;
import java.util.*;

public class M04_TieredTaxSimple {
    
    private static int calcTax(int income) {
        double tax = 0;

        if (income <= 120000) {
            tax = income * 0.05;
        } else if (income <= 500000) {
            tax = 120000 * 0.05 +
                  (income - 120000) * 0.12;
        } else if (income <= 1000000) {
            tax = 120000 * 0.05 +
                  (500000 - 120000) * 0.12 +
                  (income - 500000) * 0.20;
        } else {
            tax = 120000 * 0.05 +
                  (500000 - 120000) * 0.12 +
                  (1000000 - 500000) * 0.20 +
                  (income - 1000000) * 0.30;
        }

      
        return (int)Math.round(tax);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long total = 0;
        int[] taxes = new int[n];

        for (int i = 0; i < n; i++) {
            int income = sc.nextInt();
            taxes[i] = calcTax(income);
            total += taxes[i];
        }

        for (int t : taxes) {
            System.out.println("Tax: " + t);
        }
        System.out.println("Average: " + (int)(total / n));

        sc.close();
    }
}
/*
     * Time Complexity: O(n)
     * 說明：
     * 1) 對每個收入逐一計算稅額，稅率表為常數級距 (4 段)。
     * 2) 單筆計算 O(1)，總計 O(n)。
     * 3) 平均值計算也是 O(1)，所以整體 O(n)。
     */
