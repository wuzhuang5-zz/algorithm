package com.wz.tree;

import java.util.Stack;

/**
 * 判断一棵树是否为搜索二叉树和完全二叉树
 */
public class IsBST {
    static class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 中序遍历
     * @param root
     * @return
     */
    public static boolean isBST1(TreeNode root) {
        if(root == null) {
            return false;
        }
        int maxValue = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.value < maxValue) {
                    return false;
                }
                maxValue = root.value;
                root = root.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(13);
        root.right = new TreeNode(21);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(26);
        System.out.println(isBST1(root));
    }
}
