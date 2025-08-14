

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
    }
}

public class AVLBasicExercise {
    Node root;

    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public boolean search(Node node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        if (key < node.key) return search(node.left, key);
        return search(node.right, key);
    }

    public boolean search(int key) {
        return search(root, key);
    }

    public int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public int height() {
        return height(root);
    }

    public boolean isAVL(Node node) {
        if (node == null) return true;
        int balanceFactor = height(node.left) - height(node.right);
        if (Math.abs(balanceFactor) > 1) return false;
        return isAVL(node.left) && isAVL(node.right);
    }

    public boolean isAVL() {
        return isAVL(root);
    }

    public static void main(String[] args) {
        AVLBasicExercise tree = new AVLBasicExercise();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(8);

        System.out.println("搜尋 8: " + tree.search(8));
        System.out.println("高度: " + tree.height());
        System.out.println("是否為 AVL 樹: " + tree.isAVL());
    }
}
