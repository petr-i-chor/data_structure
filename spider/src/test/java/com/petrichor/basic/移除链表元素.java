package com.petrichor.basic;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 15:02 2022/1/18
 */
public class 移除链表元素 {


    /**
     * @author: jh
     * @description: 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,6,3,4,5,6], val = 6
     * 输出：[1,2,3,4,5]
     * 示例 2：
     * <p>
     * 输入：head = [], val = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [7,7,7,7], val = 7
     * 输出：[]
     *  
     * <p>
     * 提示：
     * <p>
     * 列表中的节点数目在范围 [0, 104] 内
     * 1 <= Node.val <= 50
     * 0 <= val <= 50
     * @params:
     * @return:
     */


    @Test
    public void main() {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
//        ListNode head = new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7)))));
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2)));
        ListNode listNode = removeElements2(head, 2);
        while (true) {
            if (listNode == null)
                break;
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode next = null;
        while (true) {
            if (head == null || head.val != val)
                break;
            head = head.next;
        }

        if (head == null)
            return head;

        next = head.next;

        while (true) {
            if (next == null || next.val != val)
                break;
            next = next.next;
        }

        head.next = next;

        while (true) {
            if (next == null || next.next == null)
                break;
            else if (next.next.val == val)
                next.next = next.next.next;
            else next = next.next;
        }
        return head;
    }


    public ListNode removeElements2(ListNode head, int val) {

        while (head != null) {
            if (head.val != val)
                break;
            head = head.next;
        }

        if (head == null)
            return head;

        ListNode cur = head;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }

        return head;
    }


    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
