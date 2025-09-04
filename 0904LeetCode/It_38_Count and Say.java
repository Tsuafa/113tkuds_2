package 0904LeetCode;
class Solution {
    public String countAndSay(int n) {
        String result = "1";
        
        for (int i = 2; i <= n; i++) {
            result = getNext(result);
        }
        
        return result;
    }
    
    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i - 1));
                count = 1;
            }
        }
        
        return sb.toString();
    }
}

/*
Time Complexity: O(m)  // m 為最後結果字串長度，n<=30 時字串長度大約 2^n 增長，但題目可接受
Space Complexity: O(m) // StringBuilder 暫存結果
*/
