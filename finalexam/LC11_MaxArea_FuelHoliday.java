package finalexam;


import java.util.*;

public class LC11_MaxArea_FuelHoliday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        sc.close();
        
        int maxArea = maxArea(heights);
        System.out.println(maxArea);
    }
    
    public static int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}

/*
時間複雜度: O(n)  // 每個指標最多移動 n 次
空間複雜度: O(1)  // 常數變數
*/
