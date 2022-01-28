package com.petrichor.toof;

import com.petrichor.basic.二叉树的最大深度;
import org.junit.Test;

import java.util.*;

/**
 * @Author jh
 * @Description
 * @Date created in 9:14 2022/1/27
 */

/**
 * 3                             0
 * 9    20                    2         4
 * 15   7                 1  null  3    -1
 *                       5  1         6     8
 */
public class 从上到下打印二叉树III {

    @Test
    public void main() {
//        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        TreeNode root = new TreeNode(0,
                new TreeNode(2, new TreeNode(1, new TreeNode(5), new TreeNode(1)), null),
                new TreeNode(4, new TreeNode(3, null, new TreeNode(6)), new TreeNode(-1, null, new TreeNode(8))));
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int height = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (height%2==1){
//                int length = list.size();
//                for (int i = 0; i < length >> 1; i++) {
//                    int temp =list.get(i);
//                    list.set(i,list.get(length-i-1));
//                    list.set(length-i-1,temp);
//                }
                Collections.reverse(list);
            }
            res.add(list);
            height++;
        }

        return res;
    }

}
