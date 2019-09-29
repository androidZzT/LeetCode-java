package tree;

import java.util.Stack;

/**
 * Binary Search Tree PreOrder Print
 */
public class PreOrderPrint {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(6);
        tree.insert(10);
        tree.insert(9);
        stackPreOrderPrint(tree.getRoot());
    }

    /**
     * 递归前序遍历
     * @param root
     */
    public static void preOrderPrint(TreeNode root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }

    public static void stackPreOrderPrint(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (root !=null || !stack.isEmpty()) {
            while (root != null) {
                System.out.println(root.data);
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            root = top.right;
        }

    }
}
