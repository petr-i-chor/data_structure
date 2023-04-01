package com.petrichor.toof_special;

import org.junit.Test;

import java.util.Collections;

/**
 * 剑指 Offer II 027. 回文链表
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 *
 *
 * 示例 1：
 *
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 *
 *
 *
 * 输入: head = [1,2]
 * 输出: false
 *
 *
 * 提示：
 *
 * 链表 L 的长度范围为 [1, 105]
 * 0 <= node.val <= 9
 *
 *
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class 回文链表 {
    @Test
    public void main() {
        ListNode list = new ListNode(1, new ListNode(2, new ListNode(20,new ListNode(2, new ListNode(1)))));
        System.out.println(isPalindrome(list));
    }
    public boolean isPalindrome(ListNode head) {
        ListNode low = head;
        ListNode fast = head.next;

        while (fast!=null){
            low = low.next;
            fast = fast.next;
            if (fast!=null) {
                fast = fast.next;
            }else {
                break;
            }
        }
        ListNode node = reverseList(low);
        while (node!=null){
            int i1 = node.val;
            int i2 = head.val;
            if (i1==i2){
                head = head.next;
                node = node.next;
            }else {
                return false;
            }
        }


        return true;
    }

    public ListNode reverseList(ListNode head) {

        if (head==null||head.next==null)
            return head;

        ListNode node = head.next;
        while (node.next!=null){
            node = node.next;
        }
        recurrence(head);
        return node;
    }

    public ListNode recurrence(ListNode node) {
        if (node.next == null)
            return node;

        ListNode listNode = recurrence(node.next);
        listNode.next = node;
        node.next=null;
        return node;
    }
}
