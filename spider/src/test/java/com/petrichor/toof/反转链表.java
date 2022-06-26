package com.petrichor.toof;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author jh
 * @Description
 * @Date created in 14:23 2022/1/25
 */
public class 反转链表 {

    @Test
    public void main() {
        ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
        ListNode result = reverseList(head);
        while (result != null) {
            System.out.print(result.val + "\t");
            result = result.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        head =stack.pop();
        ListNode cur = head;
        while (!stack.empty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return head;

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode cache ;

        pre.next = null;
        while (cur != null){

            cache = cur.next;
            cur.next =pre;
            pre = cur;
            cur = cache;
        }
        return pre;
    }

}
