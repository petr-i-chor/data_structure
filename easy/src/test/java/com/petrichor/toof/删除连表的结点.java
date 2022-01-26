package com.petrichor.toof;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 13:54 2022/1/25
 */
public class 删除连表的结点 {

    /**
     * @author: jh
     * @description:给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 返回删除后的链表的头节点。
     * <p>
     * 注意：此题对比原题有改动
     * <p>
     * 示例 1:
     * <p>
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * <p>
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *  
     * <p>
     * 说明：
     * <p>
     * 题目保证链表中节点的值互不相同
     * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
     * @params:
     * @return:
     */


    @Test
    public void main() {
        ListNode head = new ListNode(4,new ListNode(5,new ListNode(1,new ListNode(9))));
        ListNode result = deleteNode(head, 1);
        while (result != null){
            System.out.print(result.val+"\t");
            result = result.next;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = head;
        ListNode next = head.next;

        if (pre.val == val)
            return next;

        while (true) {
            if (next == null)
                break;

            if (next.val==val){
                pre.next = next.next;
                break;
            }else{
                pre = pre.next;
                next = next.next;
            }

        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x,ListNode next) {
            val = x;
            this.next = next;
        }

    }
}
