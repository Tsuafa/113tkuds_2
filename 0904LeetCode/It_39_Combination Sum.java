package 0904LeetCode;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result); 
            current.remove(current.size() - 1); // 回溯
        }
    }
}

/*
Time Complexity: O(N^(T/M))  
    - N = candidates 長度
    - T = target
    - M = 最小的 candidate 值
    因為遞迴深度最多 T/M，分支因子為 N
Space Complexity: O(T/M)  // 遞迴深度（當前組合長度）
*/
