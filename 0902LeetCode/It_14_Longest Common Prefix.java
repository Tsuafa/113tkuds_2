package 0902LeetCode;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
}

/*
Time Complexity: O(S)
- S = 所有字串長度總和
- 每個字元最多比較一次

Space Complexity: O(1)
- 只使用固定變數
*/
