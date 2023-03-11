package com.petrichor.array;

/*
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */

import org.junit.Test;


public class 两数相加 {

    @Test
    public void main() {
//        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(1);
        ListNode l1 = new ListNode(8, new ListNode(3, new ListNode(2)));
        ListNode l2 = new ListNode(9, new ListNode(2, new ListNode(1)));
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(8)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.print(listNode.val + "\t");
        ListNode next = listNode.next;
        while (next != null) {
            System.out.print(next.val + "\t");
            next = next.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head1 = l1;
        ListNode head2 = l2;

        if (head1.val == 0 && head2.val == 0&&head1.next==null&&head2==null)
            return l3;
        else if (head1.val == 0&&head1.next==null)
            return l2;
        else if (head2.val == 0&&head2==null)
            return l1;

        if (head1.val + head2.val < 10) {
            l3.val = head1.val + head2.val;
            l3.next = new ListNode(0);
        } else {
            l3.val = head1.val + head2.val - 10;
            l3.next = new ListNode(1);
        }
        ListNode next1 = l1.next;
        ListNode next2 = l2.next;
        if (next1 == null && next2 == null && l3.next.val == 0) {
            l3.next = null;
        }
        ListNode next3 = l3.next;
        while (!(next1 == null && next2 == null)) {
            int var1 = 0;
            int var2 = 0;
            if (next1 != null) {
                var1 = next1.val;
            }
            if (next2 != null) {
                var2 = next2.val;
            }
            int var3 = next3.val;
            if (var3 + var1 + var2 < 10) {
                next3.val = var3 + var1 + var2;
                next3.next = new ListNode(0);
            } else {
                next3.val = (var3 + var1 + var2) % 10;
                next3.next = new ListNode((var3 + var1 + var2) / 10);
            }
            if (next1 != null)
                next1 = next1.next;
            if (next2 != null)
                next2 = next2.next;
            if (next1 == null && next2 == null && next3.next.val == 0) {
                next3.next = null;
            } else
                next3 = next3.next;
        }

        return l3;
    }

}
