package com.petrichor.toof;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 14:13 2022/1/25
 */
public class 链表中倒数第k个节点 {

    /**
     *
     * @author: jh
     * @description:输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     *  
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     * @params:
     * @return:
     *
     */


    @Test
    public void main() {
        ListNode head = new ListNode(4,new ListNode(5,new ListNode(1,new ListNode(9))));
        ListNode result = getKthFromEnd(head, 2);
        while (result != null){
            System.out.print(result.val+"\t");
            result = result.next;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        while (k-- > 0)
            cur = cur.next;

        while (cur != null){
                cur = cur.next;
                head = head.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

    }
}
