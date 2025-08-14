package 0814;

import java.util.*;

class Node {
    String player;
    int score, height, size;
    Node left, right;

    Node(String player, int score) {
        this.player = player;
        this.score = score;
        this.height = 1;
        this.size = 1;
    }
}

public class AVLLeaderboardSystem {
    Node root;
    Map<String, Integer> playerScores = new HashMap<>();

    int height(Node node) {
        return node == null ? 0 : node.height;
    }

    int size(Node node) {
        return node == null ? 0 : node.size;
    }

    void updateNode(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        node.size = size(node.left) + size(node.right) + 1;
    }

    int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateNode(y);
        updateNode(x);

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateNode(x);
        updateNode(y);

        return y;
    }

    // 排序依據：分數高在前，如果分數相同則按玩家名稱字母排序
    int compare(String player1, int score1, String player2, int score2) {
        if (score1 != score2) return score2 - score1;
        return player1.compareTo(player2);
    }

    Node insert(Node node, String player, int score) {
        if (node == null) return new Node(player, score);

        if (compare(player, score, node.player, node.score) < 0) {
            node.left = insert(node.left, player, score);
        } else if (compare(player, score, node.player, node.score) > 0) {
            node.right = insert(node.right, player, score);
        } else {
            return node;
        }

        updateNode(node);
        int balance = getBalance(node);

        if (balance > 1 && compare(player, score, node.left.player, node.left.score) < 0)
            return rightRotate(node);
        if (balance < -1 && compare(player, score, node.right.player, node.right.score) > 0)
            return leftRotate(node);
        if (balance > 1 && compare(player, score, node.left.player, node.left.score) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && compare(player, score, node.right.player, node.right.score) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    Node delete(Node node, String player, int score) {
        if (node == null) return null;

        if (compare(player, score, node.player, node.score) < 0) {
            node.left = delete(node.left, player, score);
        } else if (compare(pl
