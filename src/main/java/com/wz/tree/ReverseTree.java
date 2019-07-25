package com.wz.tree;

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

    public static TreeNode reverseTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = reverseTree(root.right);
        TreeNode left = reverseTree(root.left);
        root.left = right;
        root.right = left;
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
    }
}
