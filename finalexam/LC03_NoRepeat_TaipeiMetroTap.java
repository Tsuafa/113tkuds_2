package finalexam;


import java.util.*;

public class LC03_NoRepeat_TaipeiMetroTap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        
        int maxLen = lengthOfLongestSubstring(s);
        System.out.println(maxLen);
    }
    
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int left = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastIndex.containsKey(c)) {
               
                left = Math.max(left, lastIndex.get(c) + 1);
            }
            lastIndex.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}

/*
時間複雜度: O(n)  // 每個字元最多進出一次窗口
空間複雜度: O(k)  // HashMap 存放不重複字元，k 為字元集大小 (ASCII 可見字元 ~128)
*/
