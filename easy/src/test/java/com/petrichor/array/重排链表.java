package com.petrichor.array;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 10:11 2023/3/15
 */

/*
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 * 提示：
 *
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 * 通过次数237,571提交次数367,036
 */

public class 重排链表 {

    @Test
    public void main() {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        reorderList2(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {        //通过 530ms,天哪！！
        //暴力解法，o(n2)
        while (head != null) {
            ListNode next = head.next;

            if (next == null || next.next == null)
                break;

            while (next.next.next != null) {
                next = next.next;
            }
            ListNode last = next.next;
            next.next = null;
            ListNode tmp = head.next;
            head.next = last;
            last.next = tmp;
            head = head.next.next;
        }
    }

    //    12345678
    public void reorderList2(ListNode head) {
        //快慢指针，找到中点，反转链表，交叉添加
        ListNode low = head;
        ListNode fast = head.next;
        if (fast==null||fast.next==null)
            return;
        while (fast != null) {
            low = low.next;

            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
        }

        ListNode reversalHead = low.next;
        low.next = null;
        ListNode next = reversalHead.next;
        reversalHead.next=null;
        ListNode dps = dps(reversalHead, next);
        dps2(head, dps);
    }


    public ListNode dps(ListNode head, ListNode next) {
        if (next == null) {
            return head;
        } else if (next.next == null) {
            next.next = head;
            return next;
        }

        ListNode nextNext = next.next;
        next.next = head;
        return dps(next, nextNext);
    }

    public void dps2(ListNode head, ListNode next) {
        if (next == null)
            return;

        ListNode headNext = head.next;
        ListNode nextNext = next.next;
        head.next = next;
        next.next = headNext;
        dps2(headNext, nextNext);
    }
}
