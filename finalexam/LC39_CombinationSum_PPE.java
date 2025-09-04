package finalexam;


import java.util.*;

public class LC39_CombinationSum_PPE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) candidates[i] = sc.nextInt();
        sc.close();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<>(), res);

        for (List<Integer> comb : res) {
            for (int x : comb) System.out.print(x + " ");
            System.out.println();
        }
    }

    private static void backtrack(int[] nums, int start, int remain, List<Integer> comb, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remain) break;
            comb.add(nums[i]);
            backtrack(nums, i, remain - nums[i], comb, res); 
            comb.remove(comb.size() - 1);
        }
    }
}

