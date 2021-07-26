package tree;

import java.util.ArrayList;
import java.util.Stack;

public class SubStructure {

    public static void main(String[] args) {
        TreeNode A = new TreeNode(2);
        A.left = new TreeNode(3);
        A.right = new TreeNode(2);
        A.left.left = new TreeNode(1);

        TreeNode B = new TreeNode(3);
        B.right = new TreeNode(2);
        B.right.left = new TreeNode(2);

        System.out.println(isSubStructure(A, B));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        ArrayList<Integer> inordersA = new ArrayList<>();
        ArrayList<Integer> inordersB = new ArrayList<>();
        _inorderTraversal(B, inordersB);
        _inorderTraversal(A, inordersA);

        System.out.println("inordersA=" + inordersA);
        System.out.println("inordersB=" + inordersB);
        int i=0, j = 0;
        while (i < inordersA.size()) {
            if (j < inordersB.size()) {
                if (inordersA.get(i) == inordersB.get(j)) {
                    j ++;
                    i ++;
                } else {
                    j = 0;
                    i ++;
                }
            } else {
                break;
            }
        }
        return j == inordersB.size();
    }

    private static void _inorderTraversal(TreeNode node, ArrayList<Integer> inorders) {
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode top = stack.pop();
            inorders.add(top.data);
            node = top.right;
        }
    }
}
