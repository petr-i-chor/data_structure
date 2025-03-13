package com.petrichor.sort2;

import org.junit.Test;

import java.util.Arrays;

public class FightAgainSixSort {

    public static void main(String[] args) {
//        int[] nums = {3, 7, 8, 2, 1, 5, 4, 6, 9, 10};
        int[] nums = new int[10000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 10000);
        }
//        insertionSort(nums);
//        SelectionSort(nums);
//        BubbleSort(nums);
//        quickSort(nums);
//        mergeSort(nums);
//        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums) {
        int cur = 0;
        while (cur < nums.length) {
            int min = nums[cur];
            for (int i = cur + 1; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    int temp = nums[i];
                    nums[i] = nums[cur];
                    nums[cur] = temp;
                }
            }
            cur++;
        }
    }

    public static void SelectionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = i;
            while (cur >= 1 && nums[cur] < nums[cur - 1]) {
                int temp = nums[cur];
                nums[cur] = nums[cur - 1];
                nums[cur - 1] = temp;
                cur--;
            }
        }

    }

    public static void BubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (j < nums.length - i - 1 && nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int i, int i1) {
        if (i >= i1)
            return;

        int j = i + 1;
        int j1 = i1;
        int pivot = nums[i];
        while (j <= j1) {
            while (j <= j1 && nums[j] <= pivot) {
                j++;
            }
            while (j <= j1 && nums[j1] >= pivot) {
                j1--;
            }
            if (j <= j1) {
                int temp = nums[j];
                nums[j] = nums[j1];
                nums[j1] = temp;
            }
        }
        int temp = nums[i];
        nums[i] = nums[j1];
        nums[j1] = temp;

        quickSort(nums, i, j1 - 1);
        quickSort(nums, j1 + 1, i1);

    }

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int i, int i1) {
        if (i == i1)
            return;
        int mid = i + (i1 - i) / 2;
        mergeSort(nums, i, mid);
        mergeSort(nums, mid + 1, i1);
        mySort(nums, i, mid, i1);
    }

    public static void shellSort(int[] nums) {
        int step = nums.length / 2;
        while (step >= 1) {
            for (int i = 0; i < nums.length; i++) {
                int cur = i;
                while (cur >= 0) {
                    if (cur + step < nums.length && nums[cur + step] < nums[cur]) {
                        int temp = nums[cur + step];
                        nums[cur + step] = nums[cur];
                        nums[cur] = temp;
                    }
                    cur -= step;
                }
            }
            step /= 2;
        }
    }

    private static void mySort(int[] nums, int i, int mid, int i1) {
        int[] temp = new int[i1 - i + 1];
        int index = 0;
        int l = i;
        int r = mid + 1;
        while (l <= mid && r <= i1) {
            if (nums[l] > nums[r]) {
                temp[index] = nums[r];
                r++;
            } else {
                temp[index] = nums[l];
                l++;
            }
            index++;
        }
        while (l <= mid) {
            temp[index] = nums[l];
            l++;
            index++;
        }
        while (r <= i1) {
            temp[index] = nums[r];
            r++;
            index++;
        }

        int k = i;
        for (int value : temp) {
            nums[k++] = value;
        }

    }

}
