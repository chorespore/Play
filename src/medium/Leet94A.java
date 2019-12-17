package medium;

import main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet94A {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.right != null) {
                stack.add(node.right);
            }
            res.add(stack.pop().val);
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return res;
    }

}
