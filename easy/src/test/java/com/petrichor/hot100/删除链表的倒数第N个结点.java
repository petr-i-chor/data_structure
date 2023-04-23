package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 9:29 2023/4/23
 */
public class 删除链表的倒数第N个结点 {

    @Test
    public void main() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
//        ListNode head = new ListNode(1, new ListNode(2));
//        ListNode head = new ListNode(1);
        ListNode node = removeNthFromEnd(head, 3);
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = head;
        while (n > 0) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return pre.next;
    }

}
