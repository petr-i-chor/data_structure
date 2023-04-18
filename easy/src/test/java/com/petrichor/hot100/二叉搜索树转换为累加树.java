package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 9:13 2023/4/18
 */
public class 二叉搜索树转换为累加树 {

    @Test
    public void main() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), null));
        convertBST(root);
    }

    /*
      1
   2     5
 3   4  6
     */
    public TreeNode convertBST(TreeNode root) {
        int [] sum = {0};
        dps(root,sum);
        return root;
    }

    public void dps(TreeNode root,int [] sum) {
        if (root==null)
            return;
        dps(root.right,sum);
        sum[0] += root.val;
        root.val = sum[0];
        dps(root.left,sum);
    }
}
