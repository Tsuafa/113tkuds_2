package midterm;

import java.util.*;

public class M06_PalindromeClean {
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
          
            while (left < right && !Character.isLetter(s.charAt(left))) left++;
            while (left < right && !Character.isLetter(s.charAt(right))) right--;

            if (left < right) {
                char c1 = Character.toLowerCase(s.charAt(left));
                char c2 = Character.toLowerCase(s.charAt(right));
                if (c1 != c2) return false;
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(isPalindrome(line) ? "Yes" : "No");
        sc.close();
    }
}