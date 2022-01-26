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
 *       2     5         1 2 3 4 5 6            6
 *     3  4  6                                  1 2 3 4 5
 */
public class 二叉树的前序遍历 {

    @Test
    public void main() {
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),
                new TreeNode(5,new TreeNode(6),null));
        List<Integer> result = preorderTraversal4(root);
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


    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {                       //一个过程,两次循环,①压两个子结点②弹父节点
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }

    //手写一遍
    public List<Integer> preorderTraversal4(TreeNode root) {

        if (root == null) return new LinkedList<Integer>();

        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.empty()){
            if (stack.peek()!=null){
                TreeNode node = stack.pop();
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                stack.push(node);
                stack.push(null);
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
