package com.petrichor.hot100;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 19:35 2023/4/11
 */
public class 回文链表 {

    @Test
    public void main(){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(1)));
        System.out.println(isPalindrome(head));
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
