package com.petrichor.test;

import org.junit.Test;



/**
 * @Author jh
 * @Description
 * @Date created in 9:28 2022/1/18
 */
public class 环形链表 {

    /**
     * @author: jh
     * @description:给你一个链表的头节点 head ，判断链表中是否有环。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     * <p>
     * <p>
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     *  
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目范围是 [0, 104]
     * -105 <= Node.val <= 105
     * pos 为 -1 或者链表中的一个 有效索引 。
     *  
     * @params:
     * @return:
     */


    @Test
    public void main() {
//        ListNode a = new ListNode(3);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(0);
//        ListNode d = new ListNode(-4);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = b;
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        b.next = a;
        System.out.println(hasCycle(a));
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow ;
        ListNode fast ;
        if ((slow = (head)) == null || (fast = (head.next)) == null)
            return false;

        while (fast != null && fast.next != null){

            if (slow.equals(fast))
                return true;
            slow = slow.next;
            fast = fast.next.next;

        }
        return false;
    }


    //      Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
