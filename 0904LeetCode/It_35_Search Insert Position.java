package 0904LeetCode;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // left 會是 target 應插入的位置
        return left;
    }
}

/*
Time Complexity: O(log n) // 二分搜尋
Space Complexity: O(1)    // 常數空間
*/
