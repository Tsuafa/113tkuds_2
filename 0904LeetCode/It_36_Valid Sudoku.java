package 0904LeetCode;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                
                int num = c - '1'; // 將 '1'~'9' 轉成 0~8
                int boxIndex = (i / 3) * 3 + (j / 3);
                
                if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                    return false;
                }
                
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIndex][num] = true;
            }
        }
        return true;
    }
}

/*
Time Complexity: O(9*9) = O(1) // 固定大小的棋盤，只需掃一遍
Space Complexity: O(9*9) = O(1) // 三個固定大小的矩陣
*/
