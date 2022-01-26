package com.petrichor.basic;

import org.junit.Test;

import java.util.Stack;


/**
 * @Author jh
 * @Description
 * @Date created in 14:03 2022/1/20
 */
public class 有效的括号 {

    /**
     * @author: jh
     * @description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
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
     * 示例 4：
     * <p>
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     * <p>
     * 输入：s = "{[]}"
     * 输出：true
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     * @params:
     * @return:
     */


    @Test
    public void main() {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> l = new Stack<>();
        Stack<Character> r = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c =='[' || c == '{')
                l.push(c);
            else
                r.push(c);
        }
        while (!l.empty()&&!r.empty()){
            if (l.pop()=='('){
                if (r.pop()!=')')
                    return false;
            }
            if (l.pop()=='{'){
                if (r.pop()!='}')
                    return false;
            }
            if (l.pop()=='['){
                if (r.pop()!=']')
                    return false;
            }
        }
        return true;
    }


}
