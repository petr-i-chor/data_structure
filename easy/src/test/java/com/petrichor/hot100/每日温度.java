package com.petrichor.hot100;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author jh
 * @Description
 * @Date created in 15:29 2023/4/18
 */
public class 每日温度 {

    @Test
    public void main(){
        int [] temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println();
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                Integer top = stack.pop();
                int days = i - top;
                res[top] = days;
            }
            stack.push(i);
        }

        return res;
    }
}
