package com.petrichor.hot100;

import org.junit.Test;

import java.util.HashSet;

public class 环形链表 {

    @Test
    public void main() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
        System.out.println(detectCycle(head));
    }

    /*
        1 2 3 4
            6 5

        a = 2,  链表头部到链表入口长度（不包括入口）
        b = 4,  环形链表长度

        low 走了n步，fast 走了2n步
        f = 2n
        fast比low多了k圈
        f = n+kb
    得出：n = kb

        又因为 a+kb = 入口
        kb = low走过的步数
        low再走a步就是出口
        而从起点走a步也是出口
        双指针遍历即可得到出口位置
     */

    public ListNode detectCycle(ListNode head) {
        if (head==null)
            return head;

        ListNode low = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (fast == low) {
                fast = head;
                low = low.next;
                while (low != fast){
                    fast =fast.next;
                    low = low.next;
                }
                return low;
            }
            low = low.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        return fast;
    }

    public ListNode detectCycle2(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return head;
    }
}


