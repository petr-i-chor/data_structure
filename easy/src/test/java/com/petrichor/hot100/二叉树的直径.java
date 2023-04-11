package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 19:52 2023/4/11
 */
public class 二叉树的直径 {

    @Test
    public void main() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), null));
        System.out.println(diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = {0};
        dps(root, res);
        return res[0];
    }

    public void dps(TreeNode root, int[] res) {
        if (root == null)
            return;

        dps(root.left, res);
        dps(root.right, res);

        if (root.left == null && root.right == null) {
            root.val = 1;
            res[0] = Math.max(res[0],root.val-1);
        } else if (root.left == null && root.right != null) {
            root.val = root.right.val + 1;
            res[0] = Math.max(res[0],root.val-1);
        } else if (root.left != null && root.right == null) {
            root.val = root.left.val + 1;
            res[0] = Math.max(res[0],root.val-1);
        } else {
            root.val = Math.max(root.left.val, root.right.val) + 1;
            res[0] = Math.max(res[0],root.left.val+root.right.val);
        }
    }
}
