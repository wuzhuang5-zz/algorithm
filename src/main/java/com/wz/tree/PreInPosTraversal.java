package com.wz.tree;

import java.util.Stack;

/**
 * 分别用递归和非递归实现前序遍历、中序遍历、后序遍历
 */
public class PreInPosTraversal {

    public static class Node {
        private Node left;
        private Node right;
        private int value;
        Node(int value) {
            this.value = value;
        }
    }

    /**
     * 二叉树递归先序遍历
     * @param head
     */
    public static void preTraversalRecu(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        preTraversalRecu(head.left);
        preTraversalRecu(head.right);
    }

    /**
     * 二叉树递归中序遍历
     * @param head
     */
    public static void inTraversalRecu(Node head) {
        if (head == null) {
            return;
        }
        inTraversalRecu(head.left);
        System.out.println(head.value);
        inTraversalRecu(head.right);
    }

    /**
     * 二叉树递归后序遍历
     * @param head
     */
    public static void posTraversalRecu(Node head) {
        if (head == null) {
            return;
        }
        posTraversalRecu(head.left);
        posTraversalRecu(head.right);
        System.out.println(head.value);
    }

    //------------------------------------------------------非递归遍历

    /**
     * 先序遍历 非递归
     * @param head
     */
    public static void preTraversal(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    /**
     * 中序遍历 非递归
     * @param head
     */
    public static void inTraversal(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head);
                    head = head.right;
                }
            }
        }
    }

    /**
     * 后序遍历 非递归
     * @param head
     */
    public static void posTraversal(Node head) {

    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.left = new Node(1);
        head.right = new Node(3);
        head.left.left = new Node(8);
        head.left.right = new Node(5);
        head.right.left = new Node(2);
        head.right.right = new Node(7);
        inTraversal(head);
    }
}
