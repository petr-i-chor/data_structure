package com.petrichor.basic;

import org.junit.Test;


/**
 * @Author jh
 * @Description
 * @Date created in 14:47 2022/1/19
 */
public class 反转列表 {

    /**
     * @author: jh
     * @description:给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     * <p>
     * <p>
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     * <p>
     * 输入：head = []
     * 输出：[]
     * @params:
     * @return:
     */


    @Test
    public void main() {
        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode
//                (5, new ListNode(6, new ListNode(7)))))));
        ListNode listNode = reverseList(head);
        while (true) {
            if (listNode == null)
                break;
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode hn = head.next;

        if (head == null || hn == null) {
            return head;
        }

        ListNode hnn = head.next.next;

        head.next = null;
        hn.next = head;

        while (true) {
            if (hnn == null)
                break;
            head = hn;
            hn = hnn;
            hnn = hnn.next;
            hn.next = head;

        }


        return hn;
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
