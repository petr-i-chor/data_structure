package com.petrichor.hot100;

/**
 * @Author jh
 * @Description
 * @Date created in 9:50 2022/1/26
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

}
