package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 20:30 2023/4/11
 */
public class 合并二叉树 {

    @Test
    public void main() {
        TreeNode root1 = new TreeNode(1,null, new TreeNode(3,null,null));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), null));
        TreeNode treeNode = mergeTrees(root1, root2);
        System.out.println(treeNode);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return bfs(root1, root2);
    }

    public TreeNode bfs(TreeNode root1, TreeNode root2) {
        if (root2==null)
            return root1;
        if (root1==null)
            return root2;

        TreeNode root=new TreeNode(root1.val+root2.val);
        root.left = bfs(root1.left,root2.left);
        root.right = bfs(root1.right,root2.right);
        return root;
    }

}
