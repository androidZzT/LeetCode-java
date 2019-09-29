package tree;

import java.util.Stack;

/**
 * Binary Search Tree InOrder Print
 */
public class InOrderPrint {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(6);
        tree.insert(10);
        tree.insert(9);
        stackInOrderPrint(tree.getRoot());
    }

    /**
     * 递归中序遍历
     *
     * @param root
     */
    public static void inOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderPrint(root.left);
        System.out.print(root.data + " ");
        inOrderPrint(root.right);
    }

    /**
     * 借助栈的中序遍历
     * @param root
     */
    public static void stackInOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            System.out.println(top.data);
            root = top.right;
        }
    }
}
