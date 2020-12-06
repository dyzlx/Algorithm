package com.dyz.algorithm.leetcode;

/**
 *
 * x * y的网格，从左上走到右下，每次只能向右或者向下走，一共多少种走法。
 *
 */
public class GridWalking {

    public static void main(String[] args) {
        int count = walking(3, 3);
        System.out.println(count);
    }

    public static int walking(int x, int y) {
        if (x < 1 || y < 1) {
            return 0;
        }
        if (x == 1 || y == 1) {
            return 1;
        }
        return walking(x - 1, y) + walking(x, y - 1);
    }
}