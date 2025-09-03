package 0903LeetCode;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // 先排序
        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2]; // 初始化為前三個的和
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // 如果找到完全相等的，直接回傳
                if (sum == target) {
                    return sum;
                }
                
                // 更新最接近的值
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                
                // 移動指標
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest;
    }
}
