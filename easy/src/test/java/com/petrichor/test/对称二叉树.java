package com.petrichor.test;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author jh
 * @Description
 * @Date created in 9:39 2022/1/25
 */
public class 对称二叉树 {

    /**
     *
     * @author: jh
     * @description:给你一个二叉树的根节点 root ， 检查它是否轴对称。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     *  
     *
     * 提示：
     *
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     *
     * @params:
     * @return:
     *
     */


    @Test
    public void main() {
//        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(2,new TreeNode(4),new TreeNode(3)));
//        TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(3)),new TreeNode(2,null,new TreeNode(3)));
        TreeNode root = new TreeNode(2,
                new TreeNode(3,new TreeNode(4),new TreeNode(5,new TreeNode(8),new TreeNode(9))),
                new TreeNode(3,new TreeNode(5,new TreeNode(9),new TreeNode(8)),new TreeNode(4)));
        System.out.println(isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right ==null)
            return true;

        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        isSymmetric2(root.left,left);
        isSymmetric3(root.right,right);
        if (left.size() != right.size())
            return false;
        while (true){
            if (left.size() == 0 && right.size() == 0)
                break;
            if (left.pop() != right.pop())
                return false;
        }
        return true;
    }

    public void isSymmetric2(TreeNode root, LinkedList list) {
        if (root == null){
            list.add(null);
            return;
        }
        list.add(root.val);
        isSymmetric2(root.left,list);
        isSymmetric2(root.right,list);
    }

    public void isSymmetric3(TreeNode root, LinkedList list) {
        if (root == null){
            list.add(null);
            return;
        }
        list.add(root.val);
        isSymmetric3(root.right,list);
        isSymmetric3(root.left,list);
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
