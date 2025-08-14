package 0814;


    
import java.util.*;

final class Node {
    final int key, height;
    final Node left, right;

    Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.height = Math.max(height(left), height(right)) + 1;
    }

    static int height(Node node) {
        return node == null ? 0 : node.height;
    }
}

public class PersistentAVLExercise {
    List<Node> versions = new ArrayList<>();

    public PersistentAVLExercise() {
        versions.add(null);
    }

    int getBalance(Node node) {
        return node == null ? 0 : Node.height(node.left) - Node.height(node.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        return new Node(x.key, x.left, new Node(y.key, T2, y.right));
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        return new Node(y.key, new Node(x.key, x.left, T2), y.right);
    }

    Node insert(Node node, int key) {
        if (node == null) return new Node(key, null, null);

        if (key < node.key) {
            node = new Node(node.key, insert(node.left, key), node.right);
        } else if (key > node.key) {
            node = new Node(node.key, node.left, insert(node.right, key));
        } else {
            return node;
        }

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
        if (balance > 1 && key > node.left.key)
            return rightRotate(new Node(node.key, leftRotate(node.left), node.right));
        if (balance < -1 && key < node.right.key)
            return leftRotate(new Node(node.key, node.left, rightRotate(node.right)));

        return node;
    }

    public void insert(int key) {
        Node newRoot = insert(versions.get(versions.size() - 1), key);
        versions.add(newRoot);
    }

    void inOrder(Node node, List<Integer> result) {
        if (node == null) return;
        inOrder(node.left, result);
        result.add(node.key);
        inOrder(node.right, result);
    }

    public List<Integer> getVersion(int versionId) {
        if (versionId < 0 || versionId >= versions.size()) {
            throw new IllegalArgumentException("版本不存在");
        }
        List<Integer> result = new ArrayList<>();
        inOrder(versions.get(versionId), result);
        return result;
    }

    public static void main(String[] args) {
        PersistentAVLExercise tree = new PersistentAVLExercise();

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(15);

        System.out.println("版本 0: " + tree.getVersion(0));
        System.out.println("版本 1: " + tree.getVersion(1));
        System.out.println("版本 2: " + tree.getVersion(2));
        System.out.println("版本 3: " + tree.getVersion(3));
        System.out.println("版本 4: " + tree.getVersion(4));
    }
}
