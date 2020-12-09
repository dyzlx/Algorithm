package com.dyz.algorithm.leetcode;

/**
 *
 * A x * y grid, going from left top to right bottom.
 * you can only go to right or go to down,
 * how many ways are there?
 *
 */
public class GridWalking {

    public static void main(String[] args) {
        int count = walking(3, 3);
        System.out.println(count);
    }

    /*
     recursion
     */
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