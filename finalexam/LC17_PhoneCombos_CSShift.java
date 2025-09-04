package finalexam;


import java.util.*;

public class LC17_PhoneCombos_CSShift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        sc.close();
        
        List<String> res = letterCombinations(digits);
        for (String comb : res) {
            System.out.println(comb);
        }
    }
    
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        
        String[] mapping = {
            "",    
            "abc",  
            "def",  
            "ghi",  
            "jkl",  
            "mno",  
            "pqrs", 
            "tuv",  
            "wxyz"  
        };
        
        backtrack(digits, 0, new StringBuilder(), result, mapping);
        return result;
    }
    
    private static void backtrack(String digits, int index, StringBuilder sb, List<String> result, String[] mapping) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, index + 1, sb, result, mapping);
            sb.deleteCharAt(sb.length() - 1); // 回溯
        }
    }
}

/*
時間複雜度: O(Π(len(letters[digits[i]])))  // 每位數字分支展開
空間複雜度: O(n)  // 回溯深度，n 為 digits 長度
*/

