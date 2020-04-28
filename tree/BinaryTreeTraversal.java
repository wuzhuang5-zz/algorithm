import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历
 *              1
 *           2     3
 *          4 5   6 7
 */

public class BinaryTreeTraversal {

    //--------------------------------递归遍历--------------

    /**
     * 前序遍历 1 2 4 5 3 6 7
     * 先访问根节点——左子树——右子树
     */
    private List<TreeNode> list = new ArrayList<>();

    public void preOrder(TreeNode root) {
        list.add(root);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历 4 2 5 1 6 3 7
     * 先访问左子树——根节点——右子树
     */
    public void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        list.add(root);
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    /**
     * 后序遍历
     * 先访问左子树-右子树-根节点
     */
    public void postOrder(TreeNode root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        list.add(root);
    }

    //--------------------------------迭代遍历--------------

    public void preOrderIterate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            System.out.println(root);
            while (root != null) {
                System.out.println(root.value);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {

            }
        }
    }

    public static void main(String[] args) {

    }
}
