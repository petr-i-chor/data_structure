package com.petrichor.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 10:25 2022/1/24
 */
public class 二叉树的后序遍历 {

    @Test
    public void main() {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,new TreeNode(6),null));
        List<Integer> result = postorderTraversal(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+"\t");
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList result = new ArrayList();
        postorderTraversal2(root,result);
        return result;
    }

    public void postorderTraversal2(TreeNode root, ArrayList<Integer> list) {

        if (root == null)
            return;

        postorderTraversal2(root.left,list);
        postorderTraversal2(root.right,list);
        list.add(root.val);
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
