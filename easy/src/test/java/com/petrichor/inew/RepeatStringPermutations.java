package com.petrichor.inew;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatStringPermutations {

    @Test
    public void main() {
        String[] abcs = permutation("eqq");
        System.out.println();
    }

    public String[] permutation(String S) {
        HashSet<String> res = new HashSet<>();
        permutation(S, new StringBuffer(), new boolean[S.length()], res);
        return res.toArray(new String[0]);
    }

    public void permutation(String S, StringBuffer start, boolean[] used, HashSet<String> res) {
        if (start.length() == S.length()) {
            res.add(start.toString());
            return;
        }

        char[] charArray = S.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (used[i]) {
                continue;
            }
            start.append(charArray[i]);
            used[i] = true;
            permutation(S, start, used, res);

            //回溯
            start.deleteCharAt(start.length() - 1);
            used[i] = false;
        }
    }
}
