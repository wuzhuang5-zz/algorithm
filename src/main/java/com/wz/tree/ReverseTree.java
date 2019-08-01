package com.wz.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 */
public class ReverseTree {

    static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int value;
        TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 递归翻转二叉树
     * @param root
     * @return
     */
    public static TreeNode reverseTreeRecu(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = reverseTreeRecu(root.right);
        TreeNode left = reverseTreeRecu(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 迭代翻转二叉树
     * @param root
     * @return
     */
    public static TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode tmp = current.left;
            current.left = current.right;
            current.right = tmp;
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        TreeNode node = reverseTreeRecu(treeNode);
        preTraversal(node);
    }

    public static void preTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.value);
        preTraversal(treeNode.left);
        preTraversal(treeNode.right);
    }
}
