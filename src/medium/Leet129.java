package medium;

import main.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leet129 {
    List<List<Integer>> nums = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        helper(root, new ArrayList<>());
        int sum = 0;
        for (List<Integer> digits : nums) {
            int cur = 0;
            for (int digit : digits) {
                cur = cur * 10 + digit;
            }
            sum += cur;
        }
        return sum;
    }

    public void helper(TreeNode root, List<Integer> digits) {
        if (root == null) {
            return;
        }
        digits.add(root.val);
        helper(root.left, new ArrayList<>(digits));
        helper(root.right, new ArrayList<>(digits));
        if (root.left == null && root.right == null) {
            nums.add(digits);
        }
    }
}
