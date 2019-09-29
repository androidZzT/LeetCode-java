package tree;

import java.util.Stack;

public class ValidBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(8);
        root.right = new TreeNode(11);
        System.out.println(valid(root));
    }

    public static boolean valid(TreeNode root) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        int inorder = -Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode top = stack.pop();
            if (top.data < inorder) return false;
            inorder = top.data;
            root = top.right;
        }
        return true;
    }
}
