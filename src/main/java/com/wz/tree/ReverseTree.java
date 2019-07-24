package com.wz.tree;

/**
 * 反转二叉树
 */
public class ReverseTree {

    static class Node {
        private Node left;
        private Node right;
        private int value;
        Node(int value) {
            this.value = value;
        }
    }

    public static void reverseTree(Node head) {

    }
    public static void main(String[] args) {
        Node head = new Node(0);
        head.left = new Node(1);
        head.right = new Node(3);
        head.left.left = new Node(8);
        head.left.right = new Node(5);
        head.right.left = new Node(2);
        head.right.right = new Node(7);
    }
}
