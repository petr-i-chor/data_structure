package com.petrichor.toof;

/**
 * @Author jh
 * @Description
 * @Date created in 14:24 2022/1/25
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
