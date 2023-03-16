package com.petrichor.array;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 10:11 2023/3/15
 */

/*
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 * 提示：
 *
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 * 通过次数237,571提交次数367,036
 */

public class 重排链表 {

    @Test
    public void main(){
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        reorderList(head);
    }

    public void reorderList(ListNode head) {
        while (true) {
            ListNode next = head.next;

            while (next.next==null){
                next = next.next;
            }
            ListNode tmp = head.next;
            head.next=next;
            next.next=tmp;

        }
    }

}
