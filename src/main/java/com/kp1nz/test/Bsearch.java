package com.kp1nz.test;


/**
 * 二分查找算法实现
 * @author kp1nz
 * @create 2019-01-18 14:22
 */
public class Bsearch {

    public static int bSearch(int[] arr, int n, int value) {
        int first = 0;
        int last = n - 1;
        while (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] < value) {
                first = mid + 1;
            }else last = mid -1;
        }return  -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 8, 9, 11, 21, 24, 29, 88, 100, 548};
        System.out.println(bSearch(arr,13,100));
    }
}
