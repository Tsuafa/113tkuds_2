package finalexam;


import java.util.*;

public class LC32_LongestValidParen_Metro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        
        int maxLen = longestValidParentheses(s);
        System.out.println(maxLen);
    }
    
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); 
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else { 
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); 
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
}

/*
時間複雜度: O(n)  // 每個字元入棧一次、出棧一次
空間複雜度: O(n)  // 最壞情況全為 '('，棧存放 n 個索引
*/
