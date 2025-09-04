package 0904LeetCode;

class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }
    
    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (backtrack(board)) {
                                return true; // 找到解就結束
                            }
                            board[i][j] = '.'; // 回溯
                        }
                    }
                    return false; // 這格填不了任何數字，回溯
                }
            }
        }
        return true; // 全部填滿
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[row][k] == c) return false; // 檢查 row
            if (board[k][col] == c) return false; // 檢查 col
            int boxRow = 3 * (row / 3) + k / 3;
            int boxCol = 3 * (col / 3) + k % 3;
            if (board[boxRow][boxCol] == c) return false; // 檢查 box
        }
        return true;
    }
}

/*
Time Complexity: O(9^(m))  // m 為空格數，每個空格最多嘗試 9 種數字
Space Complexity: O(m)     // 遞迴深度最多 m
*/

