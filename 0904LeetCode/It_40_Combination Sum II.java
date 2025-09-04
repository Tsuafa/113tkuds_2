package 0904LeetCode;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // 排序方便去重
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // 剪枝：避免超過 target
            if (candidates[i] > target) break;
            
            // 去重：同一層的重複元素跳過
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1); // 回溯
        }
    }
}

/*
Time Complexity: O(2^N)  // 每個元素選或不選，最壞情況需去重處理
Space Complexity: O(N)   // 遞迴深度與暫存組合
*/
