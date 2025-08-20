package midterm;

import java.util.*;

public class M10_RBPropertiesCheck {

    static class Node {
        int val;
        char color; 
        Node left, right;
        Node(int v, char c) { val = v; color = c; }
    }

    
    private static Node[] buildTree(int[] vals, char[] colors) {
        int n = vals.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            if (vals[i] != -1) nodes[i] = new Node(vals[i], colors[i]);
            else nodes[i] = null;
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int li = 2*i + 1;
                int ri = 2*i + 2;
                if (li < n) nodes[i].left = nodes[li];
                if (ri < n) nodes[i].right = nodes[ri];
            }
        }
        return nodes;
    }

   
    private static boolean checkRedRed(Node root, int index) {
        if (root == null) return true;
        if (root.color == 'R') {
            if ((root.left != null && root.left.color == 'R') ||
                (root.right != null && root.right.color == 'R')) {
                System.out.println("RedRedViolation at index " + index);
                return false;
            }
        }
        return checkRedRed(root.left, 2*index+1) && checkRedRed(root.right, 2*index+2);
    }

    
    private static int checkBlackHeight(Node root) {
        if (root == null) return 1;
        int lh = checkBlackHeight(root.left);
        int rh = checkBlackHeight(root.right);
        if (lh == -1 || rh == -1 || lh != rh) return -1;
        return lh + (root.color == 'B' ? 1 : 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vals = new int[n];
        char[] colors = new char[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
            String c = sc.next();
            colors[i] = (vals[i]==-1) ? 'B' : c.charAt(0);
        }

        Node[] nodes = buildTree(vals, colors);
        Node root = nodes[0];

     
        if (root == null || root.color != 'B') {
            System.out.println("RootNotBlack");
            return;
        }

      
        if (!checkRedRed(root, 0)) return;

       
        if (checkBlackHeight(root) == -1) {
            System.out.println("BlackHeightMismatch");
            return;
        }

        System.out.println("RB Valid");
        sc.close();
    }
}

