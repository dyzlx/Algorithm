package com.dyz.algorithm.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Return 0 if the array contains less than 2 elements.
 *
 * Example 1:
 *
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 * Example 2:
 *
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 *
 * Try to solve it in linear time/space.
 *
 */
public class MaximumGapForSortedArray {

    public static void main(String[] args) {
        int[] array = new int[] {3,6,9,1};
        System.out.println(solution_1(array));
    }

    /*
     The most direct and simple way
     */
    public static int solution_1(int[] array) {
        if(Objects.isNull(array) || array.length < 2) {
            return 0;
        }
        Arrays.sort(array);
        int maxGap = 0;
        for(int i = 0 ; i < array.length -1 ; i++) {
            int j = i + 1;
            int currentGap = array[j] - array[i];
            maxGap = Math.max(currentGap, maxGap);
        }
        return maxGap;
    }

    /*
     do not use java lib built-in method Arrays.sort()
     so this problem is the same as how to sort a array in linear time and space
     so the fastest sorting algorithm is Bucket Sort
     */

    public static int solution_2(int[] array) {
        if(Objects.isNull(array) || array.length < 2) {
            return 0;
        }

        return 0;
    }

    class BucketSort {

    }
}
