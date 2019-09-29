package tree;

import java.util.LinkedList;

public class BinaryTree {
    private TreeNode root;
    LinkedList<TreeNode> queue = new LinkedList<>();

    public BinaryTree() {
        root = null;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode r, int val) {
        if (r == null) {
            return new TreeNode(val);
        }

        if (val > r.data) {
            r.right = insert(r.right, val);
        } else if (val < r.data) {
            r.left = insert(r.left, val);
        }
        return r;
    }

    /**
     * 按层遍历
     *
     * @param root
     */
    public void layerOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.addLast(root);
        while (queue.size() > 0) {
            TreeNode front = queue.removeFirst();
            System.out.print(front.data + " ");
            if (front.left != null)
                queue.addLast(front.left);
            if (front.right != null)
                queue.addLast(front.right);
        }
    }

    /**
     * 按层遍历并换行
     *
     * @param root
     */
    public void layerOrderPrintln(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.addLast(root);
        int tobePrinted = 1;//还没打印的数量
        int nextLayer = 0;//下一层的数量
        while (!queue.isEmpty()) {
            TreeNode front = queue.removeFirst();
            System.out.print(front.data + " ");
            tobePrinted--;
            if (front.left != null) {
                queue.addLast(front.left);
                nextLayer++;
            }
            if (front.right != null) {
                queue.addLast(front.right);
                nextLayer++;
            }
            if (tobePrinted == 0) {//当前层打印完毕
                System.out.println();//换行
                tobePrinted = nextLayer;//把下一层数量变为要打印的数量
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}
