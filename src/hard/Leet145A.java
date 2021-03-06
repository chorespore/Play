package hard;

import main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet145A {
    private final int WHITE = 0;
    private final int GRAY = 1;

    class ColorNode {
        TreeNode node;
        int color;

        ColorNode(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();

        if (root == null) {
            return res;
        }

        stack.push(new ColorNode(root, WHITE));
        while (!stack.isEmpty()) {
            ColorNode cn = stack.pop();
            if (cn.color == WHITE) {
                stack.push(new ColorNode(cn.node, GRAY));
                if (cn.node.right != null) {
                    stack.push(new ColorNode(cn.node.right, WHITE));
                }
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
