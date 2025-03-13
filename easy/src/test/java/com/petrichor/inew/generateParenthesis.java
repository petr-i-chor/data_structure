package com.petrichor.inew;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    @Test
    public void main() {
        List<String> list = generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        dps("", 0, 0, n, res);
        return res;
    }

    public static void dps(String str, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }
        if (left < n) dps(str + "(" , left + 1, right, n, res);
        if (right < n && right < left) dps(str + ")", left, right + 1, n, res);
    }
}
