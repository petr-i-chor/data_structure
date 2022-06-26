package com.petrichor.toof;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 14:57 2022/1/25
 */
public class 合并两个排序的链表 {

    @Test
    public void main() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode l2 = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(9))));
        ListNode result = mergeTwoLists2(l1, l2);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;


        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (true) {
            if (l1 == null) {
                pre.next = l2;
                break;
            }
            if (l2 == null) {
                pre.next = l1;
                break;
            }

            if (l2 != null && l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;

        }

        return head.next;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode head;
        if (l1.val > l2.val) {
            head = l2;
            l2 = l2.next;
        } else {
            head = l1;
            l1 = l1.next;
        }

        ListNode pre = head;
        while (true) {
            if (l1 == null) {
                pre.next = l2;
                break;
            }
            if (l2 == null) {
                pre.next = l1;
                break;
            }

            if (l2 != null && l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;

        }

        return head;
    }


}
