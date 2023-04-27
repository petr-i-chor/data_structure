package com.petrichor.golden;

import com.petrichor.basic.删除排序链表中的重复元素;
import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 9:42 2023/4/27
 */
public class 倒数第k个结点 {

    @Test
    public void main() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(kthToLast(head, 2));
    }

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

        }

        return slow.val;
    }
}
