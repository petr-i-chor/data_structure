package com.petrichor.toof;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author jh
 * @Description
 * @Date created in 15:10 2022/1/27
 */
public class 重建二叉树 {

    /**
     * @author: jh
     * @description:输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     * 示例 2:
     * <p>
     * Input: preorder = [-1], inorder = [-1]
     * Output: [-1]
     *  
     * <p>
     * 限制：
     * <p>
     * 0 <= 节点个数 <= 5000
     * @params:
     * @return:
     */


    @Test
    public void main() {
        TreeNode root = new TreeNode(3,
                new TreeNode(9, new TreeNode(8, new TreeNode(5,new TreeNode(4),null), new TreeNode(10)),null),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        int [] preorder = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        int [] inorder = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
