package com.petrichor.array;

import org.junit.Test;

import java.util.*;

/**
 * @Author jh
 * @Description
 * @Date created in 11:45 2023/2/24
 */

/*
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 *
 * 示例 1:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 104 次
 */



class MinStack {         //弄多一个列表，将栈的元素排列，每次新增移除都是log（n），查找o(1)  =》LeetCode题解，根据栈先入先出的特性，可以记录每个元素插入时的最小值，新增减少查找的时间复杂度都是o（1）
    //                                                                                               为什么:因为栈的特性，不可能删了栈中间的最小值，从而出现栈顶部的最小值找不到的情况。
    private Stack<Integer> stack;

    private int min;

    private ArrayList<Integer> list;

    public MinStack() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }

    public void push(int val) {
        this.stack.push(val);
        int nums = binarySearch(list, val, 0, list.size() - 1);
        list.add(nums, val);
    }

    public void pop() {
        Integer pop = this.stack.pop();
        int nums = binarySearch(list, pop, 0, list.size() - 1);
        list.remove(nums);
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return list.get(0);
    }

    /**
     * 找到有序链表的值，没有返回插入的位置
     */
    public int binarySearch(ArrayList<Integer> nums, int target, int start, int end) {

        if (nums.size() == 0) {
            return 0;
        }

        if (start == end && nums.get(start) != target) {
            if (nums.get(start) > target)
                return start;
            else
                return start + 1;
        }
        if (start > end && nums.get(start) != target) {
            return start;
        }
        int mid = start + (end - start >> 1);
        if (nums.get(mid) == target) {
            return mid;
        } else if (nums.get(mid) < target) {
            return binarySearch(nums, target, mid + 1, end);
        } else {
            return binarySearch(nums, target, start, mid - 1);
        }
    }

}





/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
