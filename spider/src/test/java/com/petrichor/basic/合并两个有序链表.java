package com.petrichor.basic;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author jh
 * @Description:将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * @Date created in 11:44 2022/1/18
 */
public class 合并两个有序链表 {


    @Test
    public void main() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists(list1, list2);
        do {
            System.out.println(listNode.val);
        } while ((listNode = listNode.next) != null);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null)
            return list1;

        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        ArrayList<ListNode> list = new ArrayList<>();

        while (true) {

            if (list1.val < list2.val) {
                list.add(list1);
                list1 = list1.next;
            } else {
                list.add(list2);
                list2 = list2.next;
            }
            if (list1 == null || list2 == null) {
                if (list1 == null) {
                    while (list2 != null) {
                        list.add(list2);
                        list2 = list2.next;
                    }
                } else {
                    while (list1 != null) {
                        list.add(list1);
                        list1 = list1.next;
                    }
                }
                break;
            }
        }

        ListNode head = list.get(0);
        ListNode next = list.get(1);
        head.next = next;
        for (int i = 2; i < list.size(); i++) {
            next = (next.next = list.get(i));
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
