package com.kp1nz.test;

import java.util.Arrays;

/**
 * @author kp1nz
 * @create 2019-01-23 18:55
 */
public class QuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 第一次分段
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 将左右两部分再进行递归分段
        quickSort(arr, startIndex, pivotIndex - 1);

        quickSort(arr, pivotIndex + 1, endIndex);
    }


    //分成左右两段
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int heart = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right) {
            //判断两个指针指向的数和基准元素的大小，若满足小到大则指针移动
        //控制right指针比较并左移
            while (left < right && arr[right] > heart) {
                right--;
            }
        //控制right指针比较并右移
            while (left < right && arr[left] <= heart) {
                left++;
            }
        //交换left和right指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //heart和指针重指向处交换
        int p = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = p;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,3,2,5,7};

        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
