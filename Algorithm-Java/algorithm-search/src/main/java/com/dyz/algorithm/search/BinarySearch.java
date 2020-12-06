package com.dyz.algorithm.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 9, 11, 15, 25, 36, 56, 78, 99, 105, 298};
        int index = query(nums, 15);
        System.out.println(index);
    }

    /**
     * return target index in nums
     */
    public static int query(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int midIndex = (left+right)/2;
            if(nums[midIndex] == target) {
                return midIndex;
            }
            else if(target < nums[midIndex]) {
                right = midIndex-1;
            }
            else if(target > nums[midIndex]) {
                left = midIndex+1;
            }
        }
        return -1;
    }
}
