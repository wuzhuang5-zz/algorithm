import java.util.Queue;

/**
 * @Description: 翻转二叉树   226
 * @Author: wz
 */
public class InvertTree {
    //递归
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
//        Queue
        return null;
    }
}
