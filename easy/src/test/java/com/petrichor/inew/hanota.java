package com.petrichor.inew;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hanota {

    @Test
    public void main() {
        List<Integer> A = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        List<Integer>  B = new ArrayList<>();
        List<Integer>  C = new ArrayList<>();
        hanota(A, B, C);
        System.out.println();
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A, B, C, A.size());
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        if (n == 1) {
            Integer top = A.remove(A.size() - 1);
            C.add(top);
        }else {
            hanota(A, C, B, n - 1);
            Integer bottom = A.remove(A.size() - 1);
            C.add(bottom);
            hanota(B, A, C, n - 1);
        }
    }
}
