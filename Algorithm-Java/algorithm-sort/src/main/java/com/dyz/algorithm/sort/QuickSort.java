package com.dyz.algorithm.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[] {5, 3, 7, 6, 4, 1, 7, 5, 9, 10, 8};
        sort(nums);
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    public static void sort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int key = nums[left];
        while(i < j) {
            while(nums[j] >= key && i < j) {
                j--;
            }
            swap(nums, j, i);
            while(nums[i] <= key && i < j) {
                i++;
            }
            swap(nums, i, j);
        }
        sort(nums, left, i-1);
        sort(nums, i+1, right);
    }

    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
