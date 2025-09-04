package finalexam;


import java.util.*;

public class LC01_TwoSum_THSRHoliday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }
        sc.close();
        
        int[] res = twoSum(seats, target);
        System.out.println(res[0] + " " + res[1]);
    }
    
    public static int[] twoSum(int[] seats, int target) {
      
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < seats.length; i++) {
            if (map.containsKey(seats[i])) {
               
                return new int[]{map.get(seats[i]), i};
            }
            map.put(target - seats[i], i);
        }
        
        return new int[]{-1, -1};
    }
}

/*
時間複雜度: O(n)  // 一次遍歷陣列
空間複雜度: O(n)  // HashMap 存最多 n 個元素
*/

