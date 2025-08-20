package midterm;

import java.util.*;

public class M09_AVLValidate {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    
    private static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node cur = q.poll();
            if (i < arr.length && arr[i] != -1) {
                cur.left = new Node(arr[i]);
                q.offer(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                cur.right = new Node(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

   
    private static boolean isBST(Node root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }

   
    private static int checkAVL(Node root) {
        if (root == null) return 0;
        int lh = checkAVL(root.left);
        if (lh == Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rh = checkAVL(root.right);
        if (rh == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        if (Math.abs(lh - rh) > 1) return Integer.MIN_VALUE; 
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Node root = buildTree(arr);

        boolean bstValid = isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        if (!bstValid) {
            System.out.println("Invalid BST");
        } else {
            int avl = checkAVL(root);
            if (avl == Integer.MIN_VALUE) {
                System.out.println("Invalid AVL");
            } else {
                System.out.println("Valid");
            }
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 *   - 每個節點在 isBST 檢查時最多訪問一次。
 *   - 在 checkAVL 遞迴中，每個節點也僅訪問一次。
 *   - 總計仍為 O(n)，其中 n 為節點數。
 */