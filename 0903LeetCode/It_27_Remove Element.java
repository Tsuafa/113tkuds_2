package 0903LeetCode;

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0; // 慢指標
        for (int j = 0; j < nums.length; j++) { // 快指標
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
