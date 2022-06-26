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
public class 二叉树的中序遍历 {

    /**
     * @author: jh
     * @description:给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     * <p>
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     * <p>
     * <p>
     * 输入：root = [1,2]
     * 输出：[2,1]
     * 示例 5：
     * <p>
     * <p>
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *  
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     * @params:
     * @return:
     */

    /**
     *          1
     *       2     5
     *     3  4  6         3 2 4 1 6 5
     */


    @Test
    public void main() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), null));
        List<Integer> result = inorderTraversal3(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + "\t");
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList result = new ArrayList();
        inorderTraversal2(root, result);
        return result;
    }

    public void inorderTraversal2(TreeNode root, ArrayList<Integer> list) {

        if (root == null)
            return;

        inorderTraversal2(root.left, list);
        list.add(root.val);
        inorderTraversal2(root.right, list);
    }

    public LinkedList<Integer> inorderTraversal3(TreeNode root) {

        if (root == null) return new LinkedList<Integer>();

        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()){
            if (stack.peek()!=null){
                TreeNode node = stack.pop();
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
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
