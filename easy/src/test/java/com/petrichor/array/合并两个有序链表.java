package com.petrichor.array;

/*
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * 通过次数1,326,663提交次数1,998,462
 */

import org.junit.Test;

public class 合并两个有序链表 {

    @Test
    public void main() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode head = mergeTwoLists(list1, list2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        else if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        ListNode res = new ListNode(-1);
        ListNode head = res;

        while (list1 != null && list2 != null) {

            if (list1.val > list2.val) {
                res.next = list2;
                list2 = list2.next;
                res = res.next;
            } else {
                res.next = list1;
                list1 = list1.next;
                res = res.next;
            }
        }

        if (list1 == null && list2 != null)
            res.next = list2;
        else if (list2 == null && list1 != null)
            res.next = list1;


        return head.next;
    }
}
