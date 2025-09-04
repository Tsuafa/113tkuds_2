package finalexam;


import java.util.*;

public class LC20_ValidParentheses_AlertFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        
        boolean valid = isValid(s);
        System.out.println(valid);
    }
    
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
              
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
               
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}

/*
時間複雜度: O(n)  // 每個字元最多入棧一次、出棧一次
空間複雜度: O(n)  // 最壞情況棧存放 n/2 個開括號
*/
