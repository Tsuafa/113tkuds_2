package 0902LeetCode;

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            // 移動較短的邊
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

/*
Time Complexity: O(n)
- 每個元素最多被訪問一次

Space Complexity: O(1)
- 只使用固定變數
*/
