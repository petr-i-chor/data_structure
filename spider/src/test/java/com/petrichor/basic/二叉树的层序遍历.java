package com.petrichor.basic;

import com.petrichor.toof.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @Author jh
 * @Description
 * @Date created in 15:50 2022/1/26
 */
public class 二叉树的层序遍历 {

    /**
     * @author: jh
     * @description:给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * 示例 2：
     * <p>
     * 输入：root = [1]
     * 输出：[[1]]
     * 示例 3：
     * <p>
     * 输入：root = []
     * 输出：[]
     *  
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [0, 2000] 内
     * -1000 <= Node.val <= 1000
     * @params:
     * @return:
     */


    /**
     * 1
     * 2     5
     * 3  4  6
     */

    @Test
    public void main() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), null));
        List<List<Integer>> res = levelOrder2(root);
        for (List<Integer> list:res) {
            for (Integer i :list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    //手写一遍
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            ArrayList<Integer> list = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            res.add(list);
        }
        return res;
    }


}
