package com.petrichor.toof;

import org.junit.Test;

import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 17:33 2022/2/9
 */
public class 二叉树的镜像 {

    /**
     * @author: jh
     * @description: 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * <p>
     * 例如输入：
     * <p>
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     * <p>
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 节点个数 <= 1000
     * @params:
     * @return:
     */


    @Test
    public void main() {
//        TreeNode root = new TreeNode(4,
//                new TreeNode(2,new TreeNode(1),new TreeNode(3)),
//                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode root = new TreeNode(1);
        TreeNode res = mirrorTree(root);

        从上到下打印二叉树II method = new 从上到下打印二叉树II();
        List<List<Integer>> lists = method.levelOrder(res);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
