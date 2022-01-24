package com.petrichor.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 10:25 2022/1/24
 */
public class 二叉树的前序遍历 {

    @Test
    public void main() {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,new TreeNode(6),null));
        List<Integer> result = preorderTraversal(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+"\t");
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList result = new ArrayList();
        preorderTraversal2(root,result);
        return result;
    }

    public void preorderTraversal2(TreeNode root, ArrayList<Integer> list) {

        if (root == null)
            return;

        list.add(root.val);
        preorderTraversal2(root.left,list);
        preorderTraversal2(root.right,list);
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
