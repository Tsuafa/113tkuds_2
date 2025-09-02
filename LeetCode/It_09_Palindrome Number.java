package LeetCode;

class Solution {
    public boolean isPalindrome(int x) {
        // 負數或末位是0且不為0，直接false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // 偶數位數或奇數位數
        return x == reversed || x == reversed / 10;
    }
}

