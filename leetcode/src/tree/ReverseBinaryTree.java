package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        tree.insert(9);
//        InOrderPrint.stackInOrderPrint(tree.getRoot());
        reverseTree(tree.getRoot());
        InOrderPrint.stackInOrderPrint(tree.getRoot());
    }

    public static TreeNode reverseTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        return root;
    }
}
