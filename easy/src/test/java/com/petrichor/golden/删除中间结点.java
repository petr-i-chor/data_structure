package com.petrichor.golden;

import org.junit.Test;

/**
 * @Author jh
 * @Description
 * @Date created in 16:08 2023/4/26
 */
public class 删除中间结点 {


    @Test
    public void main(){

    }

    public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
    }

}
