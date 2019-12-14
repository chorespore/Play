package medium;

import main.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

public class Leet105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        int pivot = 0;
        while (inorder[pivot++] != preorder[0]) ;

        int[] preLeft = Arrays.copyOfRange(preorder, 1, pivot);
        int[] preRight = Arrays.copyOfRange(preorder, pivot, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, pivot);
        int[] inRight = Arrays.copyOfRange(inorder, pivot, inorder.length);

        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}
