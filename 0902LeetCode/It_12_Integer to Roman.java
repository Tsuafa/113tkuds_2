package 0902LeetCode;

class Solution {
    public String intToRoman(int num) {
        int[] values  = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}

/*
Time Complexity: O(1)
- 因為 num 最大為 3999，迴圈次數有限，屬於常數時間。

Space Complexity: O(1)
- 只使用固定陣列與 StringBuilder。
*/
