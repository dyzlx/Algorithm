package com.dyz.algorithm.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 */

public class FindTwoNumbersForTargetSum {

    public static void main(String[] args) {
        int[] num = new int[]{4,6,1,2,9,8};
        //
        System.out.println(Arrays.toString(solution_1(num, 8)));
        //
        List<int[]> result = solution_1_all_result(num, 10);
        for(int[] array : result) {
            System.out.print(Arrays.toString(array) + " ");
        }
        System.out.println();
        //
        System.out.println(Arrays.toString(solution_2(num, 8)));
    }

    /*
     Two nested loops, brute force way
     */
    public static int[] solution_1(int[] num, int target) {
        int[] result = new int[2];
        if(num.length > 1000) {
            System.out.println("num is too long");
            return result;
        }
        for(int i = 0 ; i < num.length ; i++) {
            int rest = target - num[i];
            for(int j = 0 ; j < num.length ; j++) {
                if(rest == num[j] && j != i) {
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }

    /*
     Two nested loops, brute force way for all possible pairs of numbers
     */
    public static List<int[]> solution_1_all_result(int[] num, int target) {
        List<int[]> result = new ArrayList<>();
        if(num.length > 1000) {
            System.out.println("num is too long");
            return result;
        }
        for(int i = 0 ; i < num.length ; i++) {
            int rest = target - num[i];
            for(int j = i + 1 ; j < num.length ; j++) {
                if(rest == num[j]) {
                    int[] item = new int[2];
                    item[0] = i;
                    item[1] = j;
                    result.add(item);
                }
            }
        }
        return result;
    }

    /*
     we not need to find all possible pairs of numbers, so wo can do some enhance.
     while we fix one number x, the rest is to find the number which value is target-x.
     So the key is how we speed up this finding process?
     we can use a hash ...
     */
    public static int[] solution_2(int[] num, int target) {
        int[] result = new int[2];
        if(num.length > 1000) {
            System.out.println("num is too long");
            return result;
        }
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < num.length ; i++) {
            if(hashMap.containsKey(num[i])) {
                result[0] = i;
                result[1] = hashMap.get(num[i]);
            }
            hashMap.put(target - num[i], i);
        }
        return result;
    }
}
