package com.petrichor.hot100;

import com.petrichor.toof.TreeNode;
import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 18:53 2023/4/11
 */
public class 翻转二叉树 {

    @Test
    public void main(){
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode treeNode = invertTree(root);
        System.out.println(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {
        bfs(root);
        return root;
    }

    public void bfs(TreeNode root){
        if (root==null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        bfs(root.right);
        bfs(root.left);
    }
}
