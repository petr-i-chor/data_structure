package com.petrichor.toof_special;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * 示例 2：
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * <p>
 * 提示：
 * <p>
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 */

public class 展平二叉搜索树 {

    @Test
    public void main() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode res = increasingBST(root);
        System.out.println(res);
    }

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<>();
        dps(root,res);
        TreeNode head = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            head.right = res.get(i);
            head = head.right;
        }
        return res.get(0);
    }

    public void dps(TreeNode root, List<TreeNode> res) {

        if (root.left!=null) {
            dps(root.left, res);
        }
        res.add(new TreeNode(root.val));
        if (root.right!=null) {
            dps(root.right, res);
        }
    }
}
