package hard;

import main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet145A {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
}
