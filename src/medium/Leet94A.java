package medium;

import main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet94A {
    private final int WHITE = 0;
    private int GREY = 1;

    class ColorNode {
        TreeNode node;
        int color;

        ColorNode(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();

        if (root == null) {
            return res;
        }

        stack.push(new ColorNode(root, WHITE));

        while (!stack.isEmpty()) {
            ColorNode cn = stack.pop();
            if (cn.color == WHITE) {
                if (cn.node.right != null) {
                    stack.push(new ColorNode(cn.node.right, WHITE));
                }
                stack.push(new ColorNode(cn.node, GREY));
                if (cn.node.left != null) {
                    stack.push(new ColorNode(cn.node.left, WHITE));
                }
            } else {
                res.add(cn.node.val);
            }
        }
        return res;
    }
}
