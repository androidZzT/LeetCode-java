package tree;

import java.util.HashMap;
import java.util.Stack;

public class PostOrderPrint {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
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
        HashMap<TreeNode, Boolean> visitedMap = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            boolean visited = visitedMap.get(top) == null ? false : visitedMap.get(top);
            if (!visited) {
                visitedMap.put(top, true);
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            } else {
                TreeNode out = stack.pop();
                System.out.println(out.data);
            }
        }
    }
}
