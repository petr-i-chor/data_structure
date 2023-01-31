package com.petrichor.array;

/**
 * @Author jh
 * @Description
 * @Date created in 9:52 2023/1/31
 */

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */

public class 有效的括号 {

    @Test
    public void main() {
        String s = "[";
        System.out.println(isValid(s));
    }

    public boolean isValid2(String s) {             //消消乐写法  o(n)
        Stack<Character> stack = new Stack<>();
        char head = s.charAt(0);
        stack.add(head);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((head == '(' && c == ')') || (head == '[' && c == ']') || (head == '{' && c == '}')) {
                stack.pop();
                if (!stack.empty())
                    head = stack.peek();
                else
                    head = ' ';
            } else {
                stack.add(c);
                head = c;
            }
        }
        return stack.empty() ? true : false;
    }


    public boolean isValid(String s) {             //优化 找到不匹配的直接退出
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.empty()||stack.pop()!=c){
                return false;
            }
        }

        return stack.empty() ? true : false;
    }
}
