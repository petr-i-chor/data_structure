package com.petrichor.test;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 16:34 2022/1/19
 */
public class 删除排序链表中的重复元素 {

    /**
     * @author: jh
     * @description:存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     * <p>
     * 返回同样按升序排列的结果链表。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     * 示例 2：
     * <p>
     * <p>
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     *  
     * <p>
     * 提示：
     * <p>
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序排列
     * @params:
     * @return:
     */


    @Test
    public void main() {
//        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3 ,new ListNode(4,new ListNode(4,new ListNode(5,new ListNode(5,new ListNode(6)))))))));
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2)));
//        ListNode head = new ListNode(1,new ListNode(1));
        ListNode listNode = deleteDuplicates2(head);
        while (true) {
            if (listNode == null)
                break;
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return head;

        while (true) {
            if (head.next == null)
                return head;
            if (head.val != head.next.val)
                break;
            head = head.next;
        }

        ListNode next = head.next;

        while (true) {
            if (next.next == null)
                break;
            if (next.val != next.next.val)
                break;
            next = next.next;
        }
        head.next = next;

        ListNode nn = next.next;


        while (true) {
            if (nn == null || nn.next == null)
                break;
            if (nn.val == nn.next.val) {
                next.next = nn.next;
                nn = nn.next;
            } else {
                next.next = nn;
                next = nn;
                nn = nn.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {

        if (head == null)
            return head;

        ListNode cur = head;

        while (cur.next!=null){
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
       return head;
    }


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
