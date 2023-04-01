package com.petrichor.toof_special;


import org.junit.Test;

/**
 * 剑指 Offer II 024. 反转链表
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
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
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 */
public class 反转链表 {

    @Test
    public void main() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode head = reverseList(list1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
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
