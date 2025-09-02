package LeetCode;

public class It_03_Longest Substring Without Repeating Characters {
    
}import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                // 左指標右移到上次出現該字元的下一個位置
                left = Math.max(map.get(c) + 1, left);
            }

            map.put(c, right); // 更新該字元最後出現位置
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

/*
Time Complexity: O(n)
- 每個字元最多被訪問兩次（進入窗口和離開窗口）。

Space Complexity: O(min(n, charset_size))
- HashMap 儲存當前窗口字元，最多不超過字元集大小。
*/

