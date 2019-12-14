package medium;

import main.TreeNode;

import java.util.Arrays;

public class Leet106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;

        int pivot = 0;
        int len = inorder.length;
        while (inorder[pivot] != postorder[len - 1]) {
            pivot++;
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, pivot);
        int[] inRight = Arrays.copyOfRange(inorder, pivot + 1, len);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, pivot);
        int[] postRight = Arrays.copyOfRange(postorder, pivot, len - 1);

        TreeNode root = new TreeNode(postorder[len - 1]);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);

        return root;
    }
}
