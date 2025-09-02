package 0902LeetCode;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                total -= value; // 減法規則
            } else {
                total += value;
            }
        }

        return total;
    }
}

/*
Time Complexity: O(n)
- n = s.length(), 每個字元只遍歷一次

Space Complexity: O(1)
- Map 固定大小 7 個符號，使用常數空間
*/
