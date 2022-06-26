package com.petrichor.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author jh
 * @Description
 * @Date created in 10:25 2022/1/24
 */
/**
 *          1
 *       2     5          1 null 5 2 null 4 3 null ----- 1 null 5 2 null
 *     3  4  6                                           3 4
 */

public class 二叉树的后序遍历 {

    @Test
    public void main() {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(5,new TreeNode(6),null));
        List<Integer> result = postorderTraversal3(root);
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

    public LinkedList<Integer> postorderTraversal3(TreeNode root) {

        if (root == null) return new LinkedList<Integer>();

        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()){
            if (stack.peek()!=null){
                TreeNode node = stack.pop();
                stack.push(node);
                stack.push(null);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }else {
                stack.pop();
                res.add(stack.pop().val);
            }

        }
        return res;

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
