package tree;

import java.util.Stack;

public class PostOrderPrint {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(6);
        tree.insert(10);
        tree.insert(9);
        postOrderPrint(tree.getRoot());
//        stackPostOrderPrint(tree.getRoot());
    }

    public static void postOrderPrint(TreeNode root) {
        if (root == null) return;
        postOrderPrint(root.left);
        postOrderPrint(root.right);
        System.out.println(root.data);
    }

    public static void stackPostOrderPrint(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode top = stack.pop();
            root = top.right;
        }
    }
}
