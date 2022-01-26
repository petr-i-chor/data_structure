package com.petrichor.test;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 9:03 2022/1/25
 */
public class 二叉树的最大深度 {

    /**
     *
     * @author: jh
     * @description: 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     * @params:
     * @return:
     *
     */

    /**
     * 递归：将大规模问题拆分为无数个小规模问题
     * 找根节点3的最大深度 -> 9的最大深度和20的最大深度作比较
     * 找根节点20的最大深度 -> 15的最大深度和7的最大深度作比较
     *
     * 终止条件 root=null
     *
     * 循环变量 A和B比较，最大深度
     */

    @Test
    public void main(){
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,new TreeNode(6),null));
        System.out.println(maxDepth(root));
    }
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
