package com.petrichor.inew;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringPermutations {

    @Test
    public void main() {
        String[] abcs = permutation1("a");
        System.out.println();
    }

    public String[] permutation(String S) {
        HashSet<String> set = new HashSet<>();
        permutation("", S, set);
        return set.toArray(new String[0]);
    }

    public void permutation(String start, String end, HashSet<String> res) {
        if (end.length() == 1) {
            res.add(start + end);
            return;
        }
        byte[] bytes = end.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            if (i == bytes.length - 1) {
                permutation(start + (char) bytes[i], end.substring(0, i), res);
            } else if (i == 0) {
                permutation(start + (char) bytes[i], end.substring(1), res);
            } else {
                permutation(start + (char) bytes[i], end.substring(0, i) + end.substring(i + 1), res);
            }
        }
    }

    public String[] permutation1(String S) {
        ArrayList<String> res = new ArrayList<>();
        permutation1(S, new StringBuffer(), new boolean[S.length()], res);
        return res.toArray(new String[0]);
    }

    public void permutation1(String S, StringBuffer start, boolean[] used, List<String> res) {
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
            permutation1(S, start, used, res);

            //回溯
            start.deleteCharAt(start.length() - 1);
            used[i] = false;
        }
    }
}
