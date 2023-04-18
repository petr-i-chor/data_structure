package com.petrichor.hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jh
 * @Description
 * @Date created in 11:01 2023/4/18
 */
public class 二叉树展开为链表 {

    @Test
    public void main(){
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, new TreeNode(6), null));
        flatten(root);
        System.out.println();
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        bfs(root,list);
        if (list.size()<2)
            return;

        root.left =null;
        root.right = list.get(1);
        for (int i =2; i < list.size(); i++) {
            list.get(i-1).right = list.get(i);
        }
    }

    public void bfs(TreeNode root,List<TreeNode> list){
        if (root==null)
            return;
        list.add(new TreeNode(root.val));
        bfs(root.left,list);
        bfs(root.right,list);
    }
}
