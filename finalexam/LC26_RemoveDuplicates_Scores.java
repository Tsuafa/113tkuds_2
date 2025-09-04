package finalexam;


import java.util.*;

public class LC26_RemoveDuplicates_Scores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        sc.close();

        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
            if (i < len - 1) System.out.print(" ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int write = 1; 
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }
}

/*
時間複雜度: O(n)  // 每個元素訪問一次
空間複雜度: O(1)  // 原地壓縮
*/
