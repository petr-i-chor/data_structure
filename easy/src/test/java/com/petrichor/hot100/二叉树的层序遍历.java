package com.petrichor.hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 二叉树的层序遍历 {

    @Test
    public void main() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), null));
        List<List<Integer>> res = levelOrder(root);
        System.out.println();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        List<List<TreeNode>> nodes = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(root.val));
        nodes.add(Arrays.asList(root));
        bfs(nodes,res);
        return res;
    }

    public void bfs(List<List<TreeNode>> nodes, List<List<Integer>> res) {
        List<TreeNode> nodeList = nodes.get(nodes.size() - 1);
        List<TreeNode> item = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        boolean returnFlag = true;
        for (TreeNode node : nodeList) {
            if (node.left != null) {
                item.add(node.left);
                ints.add(node.left.val);
                returnFlag = false;
            }
            if (node.right != null) {
                item.add(node.right);
                ints.add(node.right.val);
                returnFlag = false;
            }
        }
        if (returnFlag)
            return;
        res.add(ints);
        nodes.add(item);
        bfs(nodes,res);
    }
}
