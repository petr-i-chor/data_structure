package com.petrichor.toof_special;

import org.junit.Test;

import java.util.HashSet;

/**
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 *
 * 示例 1：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * 示例 2：
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 *
 *
 * 提示：
 *
 * 二叉树的节点个数的范围是  [1, 104].
 * -104 <= Node.val <= 104
 * root 为二叉搜索树
 * -105 <= k <= 105
 */
public class 二叉搜索树中两个节点之和 {

    @Test
    public void main() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(findTarget(root, 12));
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();

        boolean[] b = {false};
        dps(root,set,b,k);
        return b[0];
    }

    public void dps(TreeNode root,HashSet<Integer> set,boolean[] b,int k){
        if (root==null)
            return;
        int val = root.val;
        if (set.contains(val)){
            b[0] = true;
            return;
        }else {
            set.add(k-val);
        }


        dps(root.left,set,b,k);
        dps(root.right,set,b,k);
    }

}
