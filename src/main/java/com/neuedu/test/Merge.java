package com.neuedu.test;

import java.util.Arrays;

/**
 * 归并排序
 * @author kp1nz
 * @create 2019-03-08 14:28
 */
public class Merge {
    private static void merge(int arr[], int L, int R, int M) {
        int left_size = M - L;
        int right_size = R - M + 1;
        int left[] = new int[left_size];
        int right[] = new int[right_size];
        int i, j, k;
        //fill in the left sub array
        for (i = L; i < M; i++) {
            left[i - L] = arr[i];
        }
        //fill in the right sub array
        for (i = M; i <= R; i++) {
            right[i - M] = arr[i];
        }
        //merge into original array
        i = 0;
        j = 0;
        k = 0;
        while (i < left_size && j < right_size) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        //file others
        while (i < left_size) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right_size) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int arr[], int L, int R) {
        if (L == R) {
            return;
        }else {
            int M = (L + R) / 2;
            mergeSort(arr, L, M);
            mergeSort(arr, M + 1, R);
            merge(arr, L, R, M + 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 8, 3, 10, 4, 5, 6, 7};
        int L = 0;
        int R = 7;
        mergeSort(arr, L, R);
        System.out.println(Arrays.toString(arr));
    }
}
